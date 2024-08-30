import {  Routes } from '@angular/router';
import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailsComponent } from './employees/employee-details/employee-details.component';
import { PatientsComponent } from './patients/patients.component';
import { PatientDetailsComponent } from './patients/patient-details/patient-details.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { PrescriptionsComponent } from './prescriptions/prescriptions.component';
import { ProceduresComponent } from './procedures/procedures.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { EmployeesAppointmentsComponent } from './employees-appointments/employees-appointments.component';
import { EmployeesPrescriptionsComponent } from './employees-prescriptions/employees-prescriptions.component';
import { EmployeesProceduresComponent } from './employees-procedures/employees-procedures.component';
import { EmployeeInfoComponent } from './employee-info/employee-info.component';
import { EmployeesPatientsComponent } from './employees-patients/employees-patients.component';
import { EmployeesPatientsDetailsComponent } from './employees-patients/employees-patients-details/employees-patients-details.component';



export const routes: Routes = [
    { path: 'employee-login', component: EmployeeLoginComponent },
    {path:'patient-login',component:PatientLoginComponent},
    {path:'employees',component:EmployeesComponent},
    {path:'employee-details/:id',component:EmployeeDetailsComponent},
    {path:'patients',component:PatientsComponent},
    {path:'patient-details/:id',component:PatientDetailsComponent},
    {path:'announcements',component:AnnouncementsComponent},
    {path:'prescriptions',component:PrescriptionsComponent},
    {path:'procedures',component:ProceduresComponent},
    {path:'appointments',component:AppointmentsComponent},
    {path:'employee-appointments',component:EmployeesAppointmentsComponent},
    {path:'employee-prescriptions',component:EmployeesPrescriptionsComponent},
    {path:'employee-procedures',component:EmployeesProceduresComponent},
    {path:'employee-info',component:EmployeeInfoComponent},
    {path:'employee-patients',component:EmployeesPatientsComponent},
    {path:'employees-patients-details/:id',component:EmployeesPatientsDetailsComponent},
];

