import { Component } from '@angular/core';
import PatientRequestDTO from '../models/PatientRequestDTO';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-patient-login',
  standalone: true,
  imports: [],
  templateUrl: './patient-login.component.html',
  styleUrl: './patient-login.component.css'
})
export class PatientLoginComponent {
  patientData:any;
  patientId=0;
  patient:PatientRequestDTO={
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

  username = '';
  password = '';

  constructor(
    private generalService:GeneralService,
    private router: Router,
    private http: HttpClient
  ) {}

  storeUsername(value: string) {
    this.username = value;
  }

  storePassword(value: string) {
    this.password = value;
  }
  
    login() {
    //let response = post("users", ["login"], {username: this.password})
    this.generalService.patientLogin(this.username, this.password).subscribe({
      next: (data) => {
        this.patientData = JSON.parse(JSON.stringify(data));
        console.log(this.patientData)
        this.patientId = this.patientData.id;
        this.patient.profile = this.patientData.profile;
        this.patient.credentials =this.patientData.credentials;
        this.patient.age=this.patientData.age;
        this.patient.gender=this.patientData.gender;
        this.patient.address=this.patientData.address;
        this.patient.prognosis=this.patientData.prognosis;
        this.router.navigate(["/patient-info"]);
        localStorage.setItem('patient',JSON.stringify(this.patientData));
        localStorage.setItem('companyId', this.patientData.companies[0].id);
        localStorage.setItem(
          'companyName',
          this.patientData.companies[0].name
        );
        localStorage.setItem('patientId',this.patientData.id);
      },
      error: (e) => {
        console.error(e);
      },
    });
  }
  employeeLogin(){
    this.router.navigate(["/employee-login"])
  }
}
