import { Component } from '@angular/core';
import { UpdatePatientFormComponent } from "../patients/update-patient-form/update-patient-form.component";
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import FullPatientDTO from '../models/FullPatientDTO';
import { HttpClient } from '@angular/common/http';
import { GeneralService } from '../../services/general.service';
import { PatientNavmenuComponent } from "../patient-navmenu/patient-navmenu.component";

@Component({
  selector: 'app-patient-info',
  standalone: true,
  imports: [UpdatePatientFormComponent, FormsModule, NgIf, PatientNavmenuComponent],
  templateUrl: './patient-info.component.html',
  styleUrl: './patient-info.component.css'
})
export class PatientInfoComponent {
  patient!: FullPatientDTO;
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  patientId=Number(localStorage.getItem("patientId"));
  patientFirstName!: string;
  patientLastName!: string;
  updateModalVisible = false;
  showUserOverlay = false;

  constructor(private patientDetailsService: GeneralService,private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/patient/${this.patientId}`)
    .subscribe(response => {
      this.patient = response as FullPatientDTO;
    });
    const storedPatient = localStorage.getItem('patient') as string | undefined;
    if (storedPatient) {
      const patientData: { profile: { firstName: string, lastName: string } } = JSON.parse(storedPatient);
      this.patientFirstName = patientData?.profile?.firstName ?? '';
      this.patientLastName = patientData?.profile?.lastName ?? '';
    } else {
      // handle the case where the item doesn't exist in local storage
      console.log("Patient data not found in local storage");
    }
  }
 

 

  showUpdateModal() {
    this.updateModalVisible = true;
  }

  updatePatient(updatedPatient: any): void {
    const id = this.patient.id;
    this.patientDetailsService.updatePatient(id, updatedPatient)
      .subscribe((response) => {
        console.log('Patient updated successfully:', response);
        // Update the local employee data
        this.patient = response;
      }, (error) => {
        console.error('Error updating patient:', error);
      });
  }

  

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
