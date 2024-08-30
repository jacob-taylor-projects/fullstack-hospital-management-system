import { Component } from '@angular/core';
import { UpdatePatientFormComponent } from '../../patients/update-patient-form/update-patient-form.component';
import FullPatientDTO from '../../models/FullPatientDTO';
import { GeneralService } from '../../../services/general.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-employees-patients-details',
  standalone: true,
  imports: [UpdatePatientFormComponent,NgIf],
  templateUrl: './employees-patients-details.component.html',
  styleUrl: './employees-patients-details.component.css'
})
export class EmployeesPatientsDetailsComponent {
  patient!: FullPatientDTO;
  updateModalVisible = false;
  showUserOverlay = false;

  constructor(private patientDetailsService: GeneralService, private route: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    localStorage.setItem("patientId",id.toString());
    this.patientDetailsService.getPatientDetails(id).subscribe((data:FullPatientDTO) => {
      this.patient = data;
    });
  }
  PatientsPage(){
    this.router.navigate(["/employee-patients"]);
  }

  deletePatient() {
    const id = this.patient.id;
    this.patientDetailsService.deletePatient(id).subscribe(() => {
      console.log(`Employee with ID ${id} deleted successfully!`);
      this.router.navigate(["/patients"]); // navigate back to employees list
    }, (error) => {
      console.error(`Error deleting employee: ${error}`);
    });
  }

  showUpdateModal() {
    this.updateModalVisible = true;
  }

  updatePatient(updatedPatient: any): void {
    const id = this.patient.id;
    this.patientDetailsService.updatePatient(id, updatedPatient)
      .subscribe((response) => {
        console.log('Employee updated successfully:', response);
        // Update the local employee data
        this.patient = response;
      }, (error) => {
        console.error('Error updating employee:', error);
      });
  }

  

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}
