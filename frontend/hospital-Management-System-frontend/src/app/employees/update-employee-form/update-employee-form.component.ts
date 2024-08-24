import { NgIf } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import EmployeeRequestDTO from '../../models/EmployeeRequestDTO';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-update-employee-form',
  standalone: true,
  imports: [FormsModule,NgIf],
  templateUrl: './update-employee-form.component.html',
  styleUrl: './update-employee-form.component.css'
})
export class UpdateEmployeeFormComponent {
  modalVisible = true;
  employee: EmployeeRequestDTO = {
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
    admin: false,
    doctor:false,
    age:0,
    gender:'',
    address:'',
    specialty:'',
    salary:0
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
  specialty='';
  salary=0;
  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  constructor(private http: HttpClient) {}

  addEmployee(form: any) {
    this.employee.credentials.username =
      form.firstName.toLowerCase();
    this.employee.credentials.password = form.password;
    this.employee.profile.firstName = form.firstName;
    this.employee.profile.lastName = form.lastName;
    this.employee.profile.email = form.email;
    this.employee.profile.phoneNumber = form.phoneNumber;
    this.employee.age=form.age;
    this.employee.gender=form.gender;
    this.employee.address=form.address;
    this.employee.admin = form.employeeIsAdmin;
    this.employee.doctor=form.employeeIsDoctor;
    this.employee.specialty=form.specialty;
    this.employee.salary=form.salary;

    const companyId = localStorage.getItem('companyId');
    const employeeId = localStorage.getItem('employeeId');
    const url = `http://localhost:8080/company/${companyId}/employee/${employeeId}`;
  
    this.http.put<any>(url, this.employee).subscribe({
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
