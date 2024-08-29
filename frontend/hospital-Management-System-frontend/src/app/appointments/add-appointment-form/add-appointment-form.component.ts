import { NgFor } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import AppointmentDTO from '../../models/AppointmentDTO';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';

@Component({
  selector: 'app-add-appointment-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-appointment-form.component.html',
  styleUrl: './add-appointment-form.component.css'
})
export class AddAppointmentFormComponent {
  appointment: AppointmentDTO = {
    id: 0,
    name: '',
    description: '',
    date: new Date(),
    startTime: new Date(),
    endTime: new Date(),
    doctor: {
      id: 0,
      profile: {
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
      },
      age: 0,
      gender: '',
      address: '',
      admin: false,
      doctor: false,
      specialty: '',
      salary: 0,
    },
    patient: {
      id: 0,
      profile: {
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
      },
      age: 0,
      gender: '',
      address: '',
      prognosis: '',
    },
  };

  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  submitted = false;
  employee!: BasicEmployeeDTO;
  patients: BasicPatientDTO[] = [];

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

  onSubmit(form: any): void {
    this.submitted = true;
    this.appointment.name = form.name;
    this.appointment.description = form.description;
    this.appointment.date = form.date;
    this.appointment.startTime = form.startTime;
    this.appointment.endTime = form.endTime;
    this.appointment.doctor = this.employee;
    this.appointment.patient = form.patient;

    this.appointmentService.createAppointment(this.appointment).subscribe(
      (response) => {
        console.log(response);
        this.appointment = {
          id: 0,
          name: '',
          description: '',
          date: new Date(),
          startTime: new Date(),
          endTime: new Date(),
          doctor: {
            id: 0,
            profile: {
              firstName: '',
              lastName: '',
              email: '',
              phoneNumber: '',
            },
            age: 0,
            gender: '',
            address: '',
            admin: false,
            doctor: false,
            specialty: '',
            salary: 0,
          },
          patient: {
            id: 0,
            profile: {
              firstName: '',
              lastName: '',
              email: '',
              phoneNumber: '',
            },
            age: 0,
            gender: '',
            address: '',
            prognosis: '',
          },
        };
        this.submitted = false;
        window.location.reload();
        this.updateUserOverlayVisibility.emit();
      },
      (error) => {
        console.error(error);
      },
    );
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
  }
}
