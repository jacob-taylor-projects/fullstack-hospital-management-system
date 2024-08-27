import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import PrescriptionDTO from '../models/PrescriptionDTO';
import { NgFor, NgIf } from '@angular/common';
import { AddPrescriptionFormComponent } from "./add-prescription-form/add-prescription-form.component";


@Component({
  selector: 'app-prescriptions',
  standalone: true,
  imports: [NgFor, AddPrescriptionFormComponent,NgIf],
  templateUrl: './prescriptions.component.html',
  styleUrl: './prescriptions.component.css'
})
export class PrescriptionsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  prescriptions!: PrescriptionDTO[];
  showUserOverlay = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/prescriptions`)
      .subscribe(response => {
        this.prescriptions = response as PrescriptionDTO[];
      });
  }

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
