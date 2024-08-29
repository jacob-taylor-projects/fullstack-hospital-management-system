import { Component, OnInit } from '@angular/core';
import AppointmentDTO from '../models/AppointmentDTO';
import { GeneralService } from '../../services/general.service';
import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { AddAppointmentFormComponent } from "./add-appointment-form/add-appointment-form.component";
import { UpdateAppointmentFormComponent } from "./update-appointment-form/update-appointment-form.component";

@Component({
  selector: 'app-appointments',
  standalone: true,
  imports: [NgFor, AddAppointmentFormComponent, UpdateAppointmentFormComponent,NgIf],
  templateUrl: './appointments.component.html',
  styleUrl: './appointments.component.css'
})
export class AppointmentsComponent implements OnInit{
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  appointments!: AppointmentDTO[];
  showUserOverlay = false;
  selectedAppointment!: AppointmentDTO;
showUpdateOverlay= false;

toggleUpdateOverlay(appointment: AppointmentDTO) {
  this.selectedAppointment = appointment;
  this.showUpdateOverlay = true;
}

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/appointments`)
      .subscribe(response => {
        this.appointments = response as AppointmentDTO[];
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

  onUpdateAppointment(event: Event) {
    const updatedAppointment: AppointmentDTO = (event.target as any).value;
    // Update the prescription list with the updated prescription
    this.appointments = this.appointments.map((appointment) => {
      if (appointment.id === updatedAppointment.id) {
        return updatedAppointment;
      }
      return appointment;
    });
  }
  deleteAppointment(appointment: AppointmentDTO) {
    // Call the API to delete the prescription
    this.http.delete(`http://localhost:8080/company/${this.companyId}/appointment/${appointment.id}`)
      .subscribe(() => {
        // Remove the prescription from the list
        this.appointments = this.appointments.filter((a) => a.id !== appointment.id);
      });
  }
 
  
}
