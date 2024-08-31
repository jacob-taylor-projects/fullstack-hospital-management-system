import { Component } from '@angular/core';
import { EmployeeCardComponent } from "../employees/employee-card/employee-card.component";
import { NgFor } from '@angular/common';
import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { GeneralService } from '../../services/general.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PatientNavmenuComponent } from "../patient-navmenu/patient-navmenu.component";

@Component({
  selector: 'app-patients-doctors',
  standalone: true,
  imports: [EmployeeCardComponent, NgFor, PatientNavmenuComponent],
  templateUrl: './patients-doctors.component.html',
  styleUrl: './patients-doctors.component.css'
})
export class PatientsDoctorsComponent {
  employees: FullEmployeeDTO[] = [];
  showUserOverlay = false;
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  patientId=Number(localStorage.getItem("patientId"));
  patientFirstName!: string;
  patientLastName!: string;
  constructor(private patientService: GeneralService, private router: Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.getDoctors();
    const storedPatient = localStorage.getItem('patient') as string | undefined;
      if (storedPatient) {
        const patientData: { profile: { firstName: string, lastName: string } } = JSON.parse(storedPatient);
        this.patientFirstName = patientData?.profile?.firstName ?? '';
        this.patientLastName = patientData?.profile?.lastName ?? '';
      } else {
        // handle the case where the item doesn't exist in local storage
        console.log("Employee data not found in local storage");
      }
  }

  private getDoctors() {
    this.getDoctorsList().subscribe((data: FullEmployeeDTO[]) => {
      this.employees = data;
    });
  }
 

  getDoctorsList(): Observable<any> {
    return this.http.get(`http://localhost:8080/company/${this.companyId}/patient/${this.patientId}/doctors`);
  }

  employeeDetails(id: number) {
    this.router.navigate(['patients-doctors-details', id]);
  }
}
