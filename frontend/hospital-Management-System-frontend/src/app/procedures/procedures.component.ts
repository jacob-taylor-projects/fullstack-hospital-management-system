import { Component } from '@angular/core';
import { AddProcedureFormComponent } from "./add-procedure-form/add-procedure-form.component";
import { UpdateProcedureFormComponent } from "./update-procedure-form/update-procedure-form.component";
import { NgFor, NgIf } from '@angular/common';
import ProcedureDTO from '../models/ProcedureDTO';
import { HttpClient } from '@angular/common/http';
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-procedures',
  standalone: true,
  imports: [AddProcedureFormComponent, UpdateProcedureFormComponent, NgFor, NgIf, EmployeeNavmenuComponent],
  templateUrl: './procedures.component.html',
  styleUrl: './procedures.component.css'
})
export class ProceduresComponent {
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
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
    this.http.get(`http://localhost:8080/company/${this.companyId}/procedures`)
      .subscribe(response => {
        this.procedures = response as ProcedureDTO[];
      });
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
