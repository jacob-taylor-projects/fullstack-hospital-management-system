import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { AddPrescriptionFormComponent } from '../prescriptions/add-prescription-form/add-prescription-form.component';
import { UpdatePrescriptionFormComponent } from '../prescriptions/update-prescription-form/update-prescription-form.component';
import PrescriptionDTO from '../models/PrescriptionDTO';
import { HttpClient } from '@angular/common/http';
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-employees-prescriptions',
  standalone: true,
  imports: [NgFor, NgIf, AddPrescriptionFormComponent, UpdatePrescriptionFormComponent, EmployeeNavmenuComponent],
  templateUrl: './employees-prescriptions.component.html',
  styleUrl: './employees-prescriptions.component.css'
})
export class EmployeesPrescriptionsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  employeeId=Number(localStorage.getItem("employeeId"));
  employeeFirstName!: string;
  employeeLastName!: string;
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
    this.http.get(`http://localhost:8080/company/${this.companyId}/employee/${this.employeeId}/prescriptions`)
      .subscribe(response => {
        this.prescriptions = response as PrescriptionDTO[];
      });
      const storedEmployee = localStorage.getItem('employee') as string | undefined;
      if (storedEmployee) {
        const employeeData: { profile: { firstName: string, lastName: string } } = JSON.parse(storedEmployee);
        this.employeeFirstName = employeeData?.profile?.firstName ?? '';
        this.employeeLastName = employeeData?.profile?.lastName ?? '';
      } else {
        // handle the case where the item doesn't exist in local storage
        console.log("Employee data not found in local storage");
      }
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
