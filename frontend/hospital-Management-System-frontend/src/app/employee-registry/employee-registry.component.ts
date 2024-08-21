import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-registry',
  standalone: true,
  imports: [NgFor,NgClass,NgIf],
  templateUrl: './employee-registry.component.html',
  styleUrl: './employee-registry.component.css'
})
export class EmployeeRegistryComponent {
  employees: FullEmployeeDTO[] = [];
  showUserOverlay = false;
  companyId:string='';

  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.companyId = localStorage.getItem("companyId") || "";
    this.getEmployees();
  }

  getEmployees() {
    const url = `http://localhost:8080/company/${this.companyId}/employees`;
    this.http.get<any>(url).subscribe({
      next: (res) => {
        this.employees = res;
        console.log(res)
      },
      error: (e) => console.error(e)
    });
  }

  toggleUserOverlay() {
    this.showUserOverlay = !this.showUserOverlay;
  }
  onOverlayVisibilityChange() {
    this.showUserOverlay = false;
  }

  sendToDetails(employeeId: number) {
    this.router.navigate(["/employee-details", employeeId]);
  }
}
