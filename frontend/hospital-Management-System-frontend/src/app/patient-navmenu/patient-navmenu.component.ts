import { Component, HostListener } from '@angular/core';
import FullPatientDTO from '../models/FullPatientDTO';
import { Router, RouterModule } from '@angular/router';
import { GeneralService } from '../../services/general.service';
import { NgClass, NgIf } from '@angular/common';

@Component({
  selector: 'app-patient-navmenu',
  standalone: true,
  imports: [NgIf,NgClass,RouterModule],
  templateUrl: './patient-navmenu.component.html',
  styleUrl: './patient-navmenu.component.css'
})
export class PatientNavmenuComponent {
  toggleMenu = false;
  companyName: any;
  scrolled = false;
  patient: FullPatientDTO | undefined = undefined;
  companyId: string | null;
  lastName!: string;
  firstName!: string;

  constructor(private router: Router,private generalService:GeneralService) {
    const patientStr = localStorage.getItem('patient');
    if (patientStr) {
      this.patient = JSON.parse(patientStr);
      if (this.patient) {
        this.firstName = this.patient.profile.firstName;
        this.lastName = this.patient.profile.lastName;
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
    if (this.generalService.patientIsLoggedIn()) this.generalService.patientLogout();
  }

  goHome() {
    this.router.navigateByUrl('/patient-info');
  }

  toggleMobileMenu() {
    this.toggleMenu = !this.toggleMenu;
  }
}
