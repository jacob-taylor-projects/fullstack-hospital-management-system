import {  Routes } from '@angular/router';
import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { EmployeeRegistryComponent } from './employee-registry/employee-registry.component';
import { EmployeeDetailsComponent } from './employee-registry/employee-details/employee-details.component';

export const routes: Routes = [
    { path: 'employee-login', component: EmployeeLoginComponent },
    {path:'patient-login',component:PatientLoginComponent},
    {path:'employee-registry',component:EmployeeRegistryComponent},
    {path:'employee-details',component:EmployeeDetailsComponent}
];

