import { Component } from '@angular/core';
import AppointmentDTO from '../models/AppointmentDTO';
import { HttpClient } from '@angular/common/http';
import { AddAppointmentFormComponent } from "../appointments/add-appointment-form/add-appointment-form.component";
import { UpdateAppointmentFormComponent } from "../appointments/update-appointment-form/update-appointment-form.component";
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-employees-appointments',
  standalone: true,
  imports: [AddAppointmentFormComponent, UpdateAppointmentFormComponent,NgFor,NgIf],
  templateUrl: './employees-appointments.component.html',
  styleUrl: './employees-appointments.component.css'
})
export class EmployeesAppointmentsComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  employeeId=Number(localStorage.getItem("employeeId"));
  employeeFirstName!: string;
  employeeLastName!: string;
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
    this.http.get(`http://localhost:8080/company/${this.companyId}/employee/${this.employeeId}/appointments`)
      .subscribe(response => {
        this.appointments = response as AppointmentDTO[];
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
