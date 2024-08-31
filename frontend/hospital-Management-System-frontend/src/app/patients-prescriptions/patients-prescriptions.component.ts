import { Component } from '@angular/core';
import PrescriptionDTO from '../models/PrescriptionDTO';
import { HttpClient } from '@angular/common/http';
import { NgFor } from '@angular/common';
import { PatientNavmenuComponent } from "../patient-navmenu/patient-navmenu.component";

@Component({
  selector: 'app-patients-prescriptions',
  standalone: true,
  imports: [NgFor, PatientNavmenuComponent],
  templateUrl: './patients-prescriptions.component.html',
  styleUrl: './patients-prescriptions.component.css'
})
export class PatientsPrescriptionsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  patientId=Number(localStorage.getItem("patientId"));
  patientFirstName!: string;
  patientLastName!: string;
  prescriptions!: PrescriptionDTO[];
  



  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/patient/${this.patientId}/prescriptions`)
      .subscribe(response => {
        this.prescriptions = response as PrescriptionDTO[];
      });
      const storedPatient = localStorage.getItem('patient') as string | undefined;
      if (storedPatient) {
        const patientData: { profile: { firstName: string, lastName: string } } = JSON.parse(storedPatient);
        this.patientFirstName = patientData?.profile?.firstName ?? '';
        this.patientLastName = patientData?.profile?.lastName ?? '';
      } else {
        // handle the case where the item doesn't exist in local storage
        console.log("Employee data not found in local storage");
      }
  }
}
