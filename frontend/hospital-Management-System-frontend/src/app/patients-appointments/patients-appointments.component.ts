import { Component } from '@angular/core';
import AppointmentDTO from '../models/AppointmentDTO';
import { HttpClient } from '@angular/common/http';
import { NgFor } from '@angular/common';
import { PatientNavmenuComponent } from "../patient-navmenu/patient-navmenu.component";

@Component({
  selector: 'app-patients-appointments',
  standalone: true,
  imports: [NgFor, PatientNavmenuComponent],
  templateUrl: './patients-appointments.component.html',
  styleUrl: './patients-appointments.component.css'
})
export class PatientsAppointmentsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  patientId=Number(localStorage.getItem("patientId"));
  patientFirstName!: string;
  patientLastName!: string;
  appointments!: AppointmentDTO[];
  



  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/patient/${this.patientId}/appointments`)
      .subscribe(response => {
        this.appointments = response as AppointmentDTO[];
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
}
