import { CanActivateFn, Router } from '@angular/router';
import { GeneralService } from './general.service';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeGuard{
  constructor(private generalService: GeneralService, private router: Router) {}

  canActivate(): Observable<boolean> {
    if (this.generalService.employeeIsLoggedIn()) return new Observable((observer) => observer.next(true));
    else {
      this.router.navigate(['/employee-login']);
      return new Observable((observer) => observer.next(false));
    }
  }
}

