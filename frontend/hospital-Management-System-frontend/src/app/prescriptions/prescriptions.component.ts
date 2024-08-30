import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import PrescriptionDTO from '../models/PrescriptionDTO';
import { NgFor, NgIf } from '@angular/common';
import { AddPrescriptionFormComponent } from "./add-prescription-form/add-prescription-form.component";
import { UpdatePrescriptionFormComponent } from "./update-prescription-form/update-prescription-form.component";
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";


@Component({
  selector: 'app-prescriptions',
  standalone: true,
  imports: [NgFor, AddPrescriptionFormComponent, NgIf, UpdatePrescriptionFormComponent, EmployeeNavmenuComponent],
  templateUrl: './prescriptions.component.html',
  styleUrl: './prescriptions.component.css'
})
export class PrescriptionsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  prescriptions!: PrescriptionDTO[];
  showUserOverlay = false;
  selectedPrescription!: PrescriptionDTO;
showUpdateOverlay= false;

toggleUpdateOverlay(prescription: PrescriptionDTO) {
  this.selectedPrescription = prescription;
  this.showUpdateOverlay = true;
}

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
  onCloseUpdateOverlay() {
    // Close the update overlay
    this.showUpdateOverlay = false;
  }

  onUpdatePrescription(event: Event) {
    const updatedPrescription: PrescriptionDTO = (event.target as any).value;
    // Update the prescription list with the updated prescription
    this.prescriptions = this.prescriptions.map((prescription) => {
      if (prescription.id === updatedPrescription.id) {
        return updatedPrescription;
      }
      return prescription;
    });
  }
  deletePrescription(prescription: PrescriptionDTO) {
    // Call the API to delete the prescription
    this.http.delete(`http://localhost:8080/company/${this.companyId}/prescription/${prescription.id}`)
      .subscribe(() => {
        // Remove the prescription from the list
        this.prescriptions = this.prescriptions.filter((p) => p.id !== prescription.id);
      });
  }
 
}
