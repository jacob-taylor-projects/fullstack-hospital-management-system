import { Component } from '@angular/core';
import { AddProcedureFormComponent } from '../procedures/add-procedure-form/add-procedure-form.component';
import { UpdateProcedureFormComponent } from '../procedures/update-procedure-form/update-procedure-form.component';
import { NgFor, NgIf } from '@angular/common';
import ProcedureDTO from '../models/ProcedureDTO';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employees-procedures',
  standalone: true,
  imports: [AddProcedureFormComponent,UpdateProcedureFormComponent,NgFor,NgIf],
  templateUrl: './employees-procedures.component.html',
  styleUrl: './employees-procedures.component.css'
})
export class EmployeesProceduresComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  employeeId=Number(localStorage.getItem("employeeId"));
  employeeFirstName!: string;
  employeeLastName!: string;
  procedures!: ProcedureDTO[];
  showUserOverlay = false;
  selectedProcedure!: ProcedureDTO;
showUpdateOverlay= false;

toggleUpdateOverlay(procedure: ProcedureDTO) {
  this.selectedProcedure = procedure;
  this.showUpdateOverlay = true;
}

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/employee/${this.employeeId}/procedures`)
      .subscribe(response => {
        this.procedures = response as ProcedureDTO[];
      });
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

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
  onCloseUpdateOverlay() {
    // Close the update overlay
    this.showUpdateOverlay = false;
  }

  onUpdateProcedure(event: Event) {
    const updatedProcedure: ProcedureDTO = (event.target as any).value;
    // Update the prescription list with the updated prescription
    this.procedures = this.procedures.map((procedure) => {
      if (procedure.id === procedure.id) {
        return updatedProcedure;
      }
      return procedure;
    });
  }
  deleteProcedure(procedure: ProcedureDTO) {
    // Call the API to delete the prescription
    this.http.delete(`http://localhost:8080/company/${this.companyId}/procedure/${procedure.id}`)
      .subscribe(() => {
        // Remove the prescription from the list
        this.procedures = this.procedures.filter((p) => p.id !== procedure.id);
      });
  }
 
}
