import { Component, HostListener } from '@angular/core';
import { GeneralService } from '../../services/general.service';

import FullEmployeeDTO from '../models/FullEmployeeDTO';
import { Router, RouterModule } from '@angular/router';
import { NgClass, NgIf } from '@angular/common';

@Component({
  selector: 'app-employee-navmenu',
  standalone: true,
  imports: [NgIf,NgClass,RouterModule],
  templateUrl: './employee-navmenu.component.html',
  styleUrl: './employee-navmenu.component.css'
})
export class EmployeeNavmenuComponent {
  toggleMenu = false;
  companyName: any;
  scrolled = false;
  employee: FullEmployeeDTO | undefined = undefined;
  companyId: string | null;
  lastName!: string;
  firstName!: string;
  isAdmin!: boolean;

  constructor(private router: Router,private generalService:GeneralService) {
    const employeeStr = localStorage.getItem('employee');
    if (employeeStr) {
      this.employee = JSON.parse(employeeStr);
      if (this.employee) {
        this.firstName = this.employee.profile.firstName;
        this.lastName = this.employee.profile.lastName;
        this.isAdmin = this.employee.admin;
      }
    }
  
    this.companyName = localStorage.getItem('companyName');
    this.companyId = localStorage.getItem('companyId');
  
  }

  ngOnInit() {

  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.scrolled = window.scrollY > 0;
  }

  logout() {
    if (this.generalService.employeeIsLoggedIn()) this.generalService.employeeLogout();
  }

  goHome() {
    this.router.navigateByUrl('/announcements');
  }

  toggleMobileMenu() {
    this.toggleMenu = !this.toggleMenu;
  }
}
