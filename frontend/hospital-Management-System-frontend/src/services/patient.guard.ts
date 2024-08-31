import { CanActivateFn, Router } from '@angular/router';
import { GeneralService } from './general.service';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientGuard{
  constructor(private generalService: GeneralService, private router: Router) {}

  canActivate(): Observable<boolean> {
    if (this.generalService.patientIsLoggedIn()) return new Observable((observer) => observer.next(true));
    else {
      this.router.navigate(['/patient-login']);
      return new Observable((observer) => observer.next(false));
    }
  }
}
