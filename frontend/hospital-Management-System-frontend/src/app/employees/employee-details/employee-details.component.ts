import { Component, EventEmitter, Output } from '@angular/core';
import { GeneralService } from '../../../services/general.service';
import { ActivatedRoute, Router } from '@angular/router';
import FullEmployeeDTO from '../../models/FullEmployeeDTO';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { UpdateEmployeeFormComponent } from "../update-employee-form/update-employee-form.component";

@Component({
  selector: 'app-employee-details',
  standalone: true,
  imports: [FormsModule, NgIf, UpdateEmployeeFormComponent],
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css'
})
export class EmployeeDetailsComponent {
  employee!: FullEmployeeDTO;
  updateModalVisible = false;
  showUserOverlay = false;

  constructor(private employeeDetailsService: GeneralService, private route: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    localStorage.setItem("employeeId",id.toString());
    this.employeeDetailsService.getEmployeeDetails(id).subscribe((data:FullEmployeeDTO) => {
      this.employee = data;
    });
  }
  EmployeesPage(){
    this.router.navigate(["/employees"]);
  }

  deleteEmployee() {
    const id = this.employee.id;
    this.employeeDetailsService.deleteEmployee(id).subscribe(() => {
      console.log(`Employee with ID ${id} deleted successfully!`);
      this.router.navigate(["/employees"]); // navigate back to employees list
    }, (error) => {
      console.error(`Error deleting employee: ${error}`);
    });
  }

  showUpdateModal() {
    this.updateModalVisible = true;
  }

  updateEmployee(updatedEmployee: any): void {
    const id = this.employee.id;
    this.employeeDetailsService.updateEmployee(id, updatedEmployee)
      .subscribe((response) => {
        console.log('Employee updated successfully:', response);
        // Update the local employee data
        this.employee = response;
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
