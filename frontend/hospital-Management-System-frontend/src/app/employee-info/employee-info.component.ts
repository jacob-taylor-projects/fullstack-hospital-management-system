import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UpdateEmployeeFormComponent } from '../employees/update-employee-form/update-employee-form.component';
import { GeneralService } from '../../services/general.service';
import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { HttpClient } from '@angular/common/http';
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-employee-info',
  standalone: true,
  imports: [FormsModule, NgIf, UpdateEmployeeFormComponent, EmployeeNavmenuComponent],
  templateUrl: './employee-info.component.html',
  styleUrl: './employee-info.component.css'
})
export class EmployeeInfoComponent {
  employee!: FullEmployeeDTO;
  companyId = Number(localStorage.getItem("companyId")); // replace with the actual company ID
  employeeId=Number(localStorage.getItem("employeeId"));
  employeeFirstName!: string;
  employeeLastName!: string;
  updateModalVisible = false;
  showUserOverlay = false;

  constructor(private employeeDetailsService: GeneralService,private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get(`http://localhost:8080/company/${this.companyId}/employee/${this.employeeId}`)
    .subscribe(response => {
      this.employee = response as FullEmployeeDTO;
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
