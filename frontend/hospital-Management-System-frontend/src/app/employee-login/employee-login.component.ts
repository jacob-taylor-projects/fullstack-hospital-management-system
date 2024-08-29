import { Component } from '@angular/core';
import EmployeeRequestDTO from '../models/EmployeeRequestDTO';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employee-login',
  standalone: true,
  imports: [],
  templateUrl: './employee-login.component.html',
  styleUrl: './employee-login.component.css'
})
export class EmployeeLoginComponent {
  employeeData:any;
  employeeId=0;
  employee:EmployeeRequestDTO={
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
    admin:false,
    doctor:false,
    specialty:'',
    salary:0
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
    this.generalService.employeeLogin(this.username, this.password).subscribe({
      next: (data) => {
        this.employeeData = JSON.parse(JSON.stringify(data));
        console.log(this.employeeData)
        this.employeeId = this.employeeData.id;
        this.employee.profile = this.employeeData.profile;
        this.employee.credentials =this.employeeData.credentials;
        this.employee.age=this.employeeData.age;
        this.employee.gender=this.employeeData.gender;
        this.employee.address=this.employeeData.address;
        this.employee.admin = this.employeeData.admin;
        this.employee.doctor=this.employeeData.doctor;
        this.employee.specialty=this.employeeData.specialty;
        this.employee.salary=this.employeeData.salary;
        this.router.navigate(["/"]);
        localStorage.setItem('employee',JSON.stringify(this.employeeData));
        localStorage.setItem('companyId', this.employeeData.companies[0].id);
        localStorage.setItem(
          'companyName',
          this.employeeData.companies[0].name
        );
        localStorage.setItem('employeeId',this.employeeData.id);
      },
      error: (e) => {
        console.error(e);
      },
    });
  }
  patientLogin(){
    this.router.navigate(["/patient-login"])
  }
}
