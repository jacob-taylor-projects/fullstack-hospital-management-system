import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import AppointmentDTO from '../../models/AppointmentDTO';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';

@Component({
  selector: 'app-update-appointment-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './update-appointment-form.component.html',
  styleUrl: './update-appointment-form.component.css'
})
export class UpdateAppointmentFormComponent {
  @Input()
  appointment!: AppointmentDTO;
  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  submitted = false;
  employee: BasicEmployeeDTO | undefined;
  patients: BasicPatientDTO[] = [];
  
  showUpdateOverlay = true;

  constructor(private appointmentService: GeneralService) { }

  ngOnInit(): void {
    this.employee = localStorage.getItem("employee") ? JSON.parse(localStorage.getItem("employee")!) : undefined;
    this.appointmentService.getPatients().subscribe(
      (patients) => {
        this.patients = patients;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  onUpdate(form: any): void {
    this.submitted = true;
    this.appointment.name = form.name;
    this.appointment.description = form.description;
    this.appointment.date = form.date;
    this.appointment.startTime = form.startTime;
    this.appointment.endTime = form.endTime;
    this.appointment.doctor = form.doctor;
    this.appointmentService.getPatientDetails(form.patient.id).subscribe((patient: BasicPatientDTO) => {
      this.appointment.patient = patient;
    });
    // Assign other properties as needed

    this.appointmentService.updateAppointment(this.appointment.id, this.appointment).subscribe(
      (response) => {
        console.log(response);
        this.submitted = false;
        this.updateUserOverlayVisibility.emit();
      },
      (error) => {
        console.error(error);
      }
    );
  }
  onCloseUpdateOverlay() {
    this.showUpdateOverlay = false;
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
    this.onClose.emit(); // Emit the onClose event
  }
  
  @Output() onClose = new EventEmitter<any>();
}
