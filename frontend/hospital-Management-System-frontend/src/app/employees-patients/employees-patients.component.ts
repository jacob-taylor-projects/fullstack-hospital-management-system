import { Component } from '@angular/core';
import { PatientCardComponent } from '../patients/patient-card/patient-card.component';
import { AddPatientFormComponent } from '../patients/add-patient-form/add-patient-form.component';
import { NgFor, NgIf } from '@angular/common';
import FullPatientDTO from '../models/FullPatientDTO';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-employees-patients',
  standalone: true,
  imports: [PatientCardComponent, AddPatientFormComponent, NgFor, NgIf, EmployeeNavmenuComponent],
  templateUrl: './employees-patients.component.html',
  styleUrl: './employees-patients.component.css'
})
export class EmployeesPatientsComponent {
  patients: FullPatientDTO[] = [];
  showUserOverlay = false;
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  employeeId=Number(localStorage.getItem("employeeId"));
  employeeFirstName!: string;
  employeeLastName!: string;
  constructor(private patientService: GeneralService, private router: Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.getPatients();
    const storedEmployee = localStorage.getItem('employee') as string | undefined;
      if (storedEmployee) {
        const employeeData: { profile: { firstName: string, lastName: string } } = JSON.parse(storedEmployee);
        this.employeeFirstName = employeeData?.profile?.firstName ?? '';
        this.employeeLastName = employeeData?.profile?.lastName ?? '';
      } else {
        // handle the case where the item doesn't exist in local storage
        console.log("Employee data not found in local storage");
      }
  }

  private getPatients() {
    this.getPatientsList().subscribe((data: FullPatientDTO[]) => {
      this.patients = data;
    });
  }
 

  getPatientsList(): Observable<any> {
    return this.http.get(`http://localhost:8080/company/${this.companyId}/employee/${this.employeeId}/patients`);
  }

  patientDetails(id: number) {
    this.router.navigate(['employees-patients-details', id]);
  }
  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
