import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { GeneralService } from '../../services/general.service';
import { Observable } from 'rxjs';
import { EmployeeCardComponent } from "./employee-card/employee-card.component";
import { NgFor, NgIf } from '@angular/common';
import { AddEmployeeFormComponent } from "./add-employee-form/add-employee-form.component";
import { EmployeeNavmenuComponent } from "../employee-navmenu/employee-navmenu.component";

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [EmployeeCardComponent, NgFor, AddEmployeeFormComponent, NgIf, EmployeeNavmenuComponent],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent implements OnInit {
  employees: FullEmployeeDTO[] = [];
  showUserOverlay = false;

  constructor(private employeeService: GeneralService, private router: Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.getEmployeesList().subscribe((data: FullEmployeeDTO[]) => {
      this.employees = data;
    });
  }
  companyId=localStorage.getItem("companyId");

  getEmployeesList(): Observable<any> {
    return this.http.get(`http://localhost:8080/company/${this.companyId}/employees`);
  }

  employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
  }
  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }
}