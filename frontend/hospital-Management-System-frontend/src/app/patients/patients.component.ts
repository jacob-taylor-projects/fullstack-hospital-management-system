import { Component } from '@angular/core';
import { PatientCardComponent } from "./patient-card/patient-card.component";
import { AddPatientFormComponent } from "./add-patient-form/add-patient-form.component";
import { NgFor, NgIf } from '@angular/common';
import FullPatientDTO from '../models/FullPatientDTO';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-patients',
  standalone: true,
  imports: [PatientCardComponent, AddPatientFormComponent,NgIf,NgFor],
  templateUrl: './patients.component.html',
  styleUrl: './patients.component.css'
})
export class PatientsComponent {
  patients: FullPatientDTO[] = [];
  showUserOverlay = false;

  constructor(private patientService: GeneralService, private router: Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.getPatients();
  }

  private getPatients() {
    this.getPatientsList().subscribe((data: FullPatientDTO[]) => {
      this.patients = data;
    });
  }
  companyId=localStorage.getItem("companyId");

  getPatientsList(): Observable<any> {
    return this.http.get(`http://localhost:8080/company/${this.companyId}/patients`);
  }

  patientDetails(id: number) {
    this.router.navigate(['patient-details', id]);
  }
  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
