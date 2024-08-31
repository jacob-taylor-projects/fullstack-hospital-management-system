import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import ProcedureDTO from '../models/ProcedureDTO';
import { HttpClient } from '@angular/common/http';
import { PatientNavmenuComponent } from "../patient-navmenu/patient-navmenu.component";

@Component({
  selector: 'app-patients-procedures',
  standalone: true,
  imports: [NgFor, PatientNavmenuComponent],
  templateUrl: './patients-procedures.component.html',
  styleUrl: './patients-procedures.component.css'
})
export class PatientsProceduresComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  patientId=Number(localStorage.getItem("patientId"));
  patientFirstName!: string;
  patientLastName!: string;
  procedures!: ProcedureDTO[];
  
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/patient/${this.patientId}/procedures`)
      .subscribe(response => {
        this.procedures = response as ProcedureDTO[];
      });
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
}
