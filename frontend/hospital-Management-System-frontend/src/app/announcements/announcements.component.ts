import { Component } from '@angular/core';
import AnnouncementDTO from '../models/AnnouncementDTO';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { GeneralService } from '../../services/general.service';
import { NgFor, NgIf } from '@angular/common';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-announcements',
  standalone: true,
  imports: [NgIf, ReactiveFormsModule, NgFor, HttpClientModule, EmployeeNavmenuComponent],
  templateUrl: './announcements.component.html',
  styleUrl: './announcements.component.css'
})
export class AnnouncementsComponent {
  employee: FullEmployeeDTO | undefined = undefined;
  companyId: number = -1;
  announcementForm: FormGroup | undefined;
  announcements: AnnouncementDTO[] = [];
  paginatedAnnouncements: AnnouncementDTO[] = [];
  announcementPopup: boolean = false;
  updateAnnouncementPopup: boolean = false;
  currentPage: number = 0;
  pageSize: number = 5; // Number of announcements per page
  totalPages: number = 0;
  currentAnnouncement!: AnnouncementDTO;
  private httpClient:HttpClient

  constructor(private generalService: GeneralService, private fb: FormBuilder,httpClient:HttpClient) {
    this.httpClient=httpClient;
    
  }

  ngOnInit() {
    this.announcementForm = this.fb.group({
      title: ['', Validators.required],
      message: ['', Validators.required]
    });

    this.employee = localStorage.getItem("employee") ? JSON.parse(localStorage.getItem("employee")!) : undefined;

    this.companyId = Number(localStorage.getItem("companyId"));
    this.fetchAnnouncements();
  }

  async fetchAnnouncements() {
    try {
      const response = await fetch(`http://localhost:8080/company/${this.companyId}/announcements`);
      const data: AnnouncementDTO[] = await response.json();
      this.announcements = data.map((announcement: any) => ({
        ...announcement,
        date: new Date(announcement.date).toLocaleDateString()
      }));
      this.totalPages = Math.ceil(this.announcements.length / this.pageSize);
      this.updatePaginatedAnnouncements();
    } catch (error) {
      console.error('Error fetching announcements:', error);
    }
  }

  updatePaginatedAnnouncements() {
    const start = this.currentPage * this.pageSize;
    const end = start + this.pageSize;
    this.paginatedAnnouncements = this.announcements.slice(start, end);
  }

  newAnnouncementPopup() {
    this.announcementForm?.reset();
    this.announcementPopup = !this.announcementPopup;
  }

  async submitAnnouncement() {
    
    if (this.announcementForm && this.announcementForm.valid) {
      const { title, message } = this.announcementForm.value;
      const newAnnouncement = {
        title,
        message,
        author: this.employee,
      };

      const options = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(newAnnouncement)
      };

      try {
        const response = await fetch(`http://localhost:8080/company/${this.companyId}/announcement`, options);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.announcementForm.reset();
        this.announcementPopup = false;
        this.fetchAnnouncements(); // Refresh the list of announcements
      } catch (error) {
        console.error('Error posting announcement:', error);
      }
    }
  }

  async updateAnnouncement(announcement: AnnouncementDTO) {
    this.announcementForm = this.fb.group({
      title: [announcement.title, Validators.required],
      message: [announcement.message, Validators.required]
    });
    this.currentAnnouncement = announcement;
    this.updateAnnouncementPopup = true;
  }

  async submitUpdateAnnouncement(announcement: AnnouncementDTO) {
    if (this.announcementForm && this.announcementForm.valid) {
      const { title, message } = this.announcementForm.value;
      const updatedAnnouncement = {
        id: announcement.id,
        title,
        message,
        author: this.employee,
      };

      const options = {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedAnnouncement)
      };

      try {
        const response = await fetch(`http://localhost:8080/company/${this.companyId}/announcement/${updatedAnnouncement.id}`, options);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        this.announcementForm.reset();
        this.updateAnnouncementPopup = false;
        this.fetchAnnouncements(); // Refresh the list of announcements
      } catch (error) {
        console.error('Error updating announcement:', error);
      }
    }
  }

  deleteAnnouncement(announcementId:number): void {
    const url = `http://localhost:8080/company/${this.companyId}/announcement/${announcementId}`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
  
    this.httpClient.delete(url, { headers: headers })
      .subscribe(
        () => {
          console.log('Announcement deleted successfully!');
          this.fetchAnnouncements(); 
        },
        (error) => {
          console.error('Error deleting announcement:', error);
        }
      );
  }
  

  goToPage(page: number) {
    this.currentPage = page;
    this.updatePaginatedAnnouncements();
  }

  goToNextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.goToPage(this.currentPage + 1);
      window.scrollTo({top: 0, behavior: 'smooth'});
    }
  }

  goToPreviousPage() {
    if (this.currentPage > 0) {
      this.goToPage(this.currentPage - 1);
      window.scrollTo({top: 0, behavior: 'smooth'});
    }
  }
}
