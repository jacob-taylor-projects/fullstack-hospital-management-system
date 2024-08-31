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
import { PatientsAppointmentsComponent } from './patients-appointments/patients-appointments.component';
import { PatientsPrescriptionsComponent } from './patients-prescriptions/patients-prescriptions.component';
import { PatientsProceduresComponent } from './patients-procedures/patients-procedures.component';
import { PatientsDoctorsComponent } from './patients-doctors/patients-doctors.component';
import { PatientsDoctorsDetailsComponent } from './patients-doctors/patients-doctors-details/patients-doctors-details.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { EmployeeGuard } from '../services/employee.guard';
import { PatientGuard } from '../services/patient.guard';



export const routes: Routes = [
    {path:'',component:EmployeeLoginComponent},
    { path: 'employee-login', component: EmployeeLoginComponent },
    {path:'patient-login',component:PatientLoginComponent},
    {path:'employees',component:EmployeesComponent,canActivate:[EmployeeGuard]},
    {path:'employee-details/:id',component:EmployeeDetailsComponent,canActivate:[EmployeeGuard]},
    {path:'patients',component:PatientsComponent,canActivate:[EmployeeGuard]},
    {path:'patient-details/:id',component:PatientDetailsComponent,canActivate:[EmployeeGuard]},
    {path:'announcements',component:AnnouncementsComponent,canActivate:[EmployeeGuard]},
    {path:'prescriptions',component:PrescriptionsComponent,canActivate:[EmployeeGuard]},
    {path:'procedures',component:ProceduresComponent,canActivate:[EmployeeGuard]},
    {path:'appointments',component:AppointmentsComponent,canActivate:[EmployeeGuard]},
    {path:'employee-appointments',component:EmployeesAppointmentsComponent,canActivate:[EmployeeGuard]},
    {path:'employee-prescriptions',component:EmployeesPrescriptionsComponent,canActivate:[EmployeeGuard]},
    {path:'employee-procedures',component:EmployeesProceduresComponent,canActivate:[EmployeeGuard]},
    {path:'employee-info',component:EmployeeInfoComponent,canActivate:[EmployeeGuard]},
    {path:'employee-patients',component:EmployeesPatientsComponent,canActivate:[EmployeeGuard]},
    {path:'employees-patients-details/:id',component:EmployeesPatientsDetailsComponent,canActivate:[EmployeeGuard]},
    {path:'patients-appointments',component:PatientsAppointmentsComponent,canActivate:[PatientGuard]},
    {path:'patients-prescriptions',component:PatientsPrescriptionsComponent,canActivate:[PatientGuard]},
    {path:'patients-procedures',component:PatientsProceduresComponent,canActivate:[PatientGuard]},
    {path:'patients-doctors',component:PatientsDoctorsComponent,canActivate:[PatientGuard]},
    {path:'patients-doctors-details/:id',component:PatientsDoctorsDetailsComponent,canActivate:[PatientGuard]},
    {path:'patient-info',component:PatientInfoComponent,canActivate:[PatientGuard]}
];

