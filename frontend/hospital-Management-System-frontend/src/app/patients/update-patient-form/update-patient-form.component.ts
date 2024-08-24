import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import PatientRequestDTO from '../../models/PatientRequestDTO';
import { HttpClient } from '@angular/common/http';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-update-patient-form',
  standalone: true,
  imports: [FormsModule,NgIf],
  templateUrl: './update-patient-form.component.html',
  styleUrl: './update-patient-form.component.css'
})
export class UpdatePatientFormComponent {
  modalVisible = true;
  patient: PatientRequestDTO = {
    credentials: {
      username: '',
      password: '',
    },
    profile: {
      firstName: '',
      lastName: '',
      email: '',
      phoneNumber: '',
    },
    age:0,
    gender:'',
    address:'',
    prognosis:''
  };
  result = '';
  firstName = '';
  lastName = '';
  password = '';
  confirmPassword = '';
  email = '';
  age=0;
  gender='';
  address='';
  prognosis='';
  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  constructor(private http: HttpClient) {}

  addPatient(form: any) {
    this.patient.credentials.username =
      form.firstName.toLowerCase();
    this.patient.credentials.password = form.password;
    this.patient.profile.firstName = form.firstName;
    this.patient.profile.lastName = form.lastName;
    this.patient.profile.email = form.email;
    this.patient.profile.phoneNumber = form.phoneNumber;
    this.patient.age=form.age;
    this.patient.gender=form.gender;
    this.patient.address=form.address;
    this.patient.prognosis=form.prognosis;

    const companyId = localStorage.getItem('companyId');
    const patientId = localStorage.getItem('patientId');
    const url = `http://localhost:8080/company/${companyId}/patient/${patientId}`;
  
    this.http.put<any>(url, this.patient).subscribe({
      error: (e) => {
        console.log(e);
        this.result = 'something went wrong';
      },
      complete: () => {
        window.location.reload();
        this.handleOverlayExit();
      },
    });
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
  }
}
