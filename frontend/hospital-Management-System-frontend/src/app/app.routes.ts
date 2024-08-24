import {  Routes } from '@angular/router';
import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailsComponent } from './employees/employee-details/employee-details.component';



export const routes: Routes = [
    { path: 'employee-login', component: EmployeeLoginComponent },
    {path:'patient-login',component:PatientLoginComponent},
    {path:'employees',component:EmployeesComponent},
    {path:'employee-details/:id',component:EmployeeDetailsComponent}
];

