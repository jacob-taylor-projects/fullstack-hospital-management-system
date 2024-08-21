import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  
  constructor(private http: HttpClient, private router: Router) {}

  employeeLogin(username: string, password: string): Observable<string> {
    return this.http.post<any>('http://localhost:8080/employees/login', {
      username: username.toLowerCase(),
      password: password,
    });
  }
  employeeLogout(): void {
    localStorage.removeItem('employee');

    this.router.navigate(['/employee-login']);
  }

  employeeIsLoggedIn(): boolean {
    return localStorage.getItem('employee') != null;
  }
  patientLogin(username: string, password: string): Observable<string> {
    return this.http.post<any>('http://localhost:8080/patients/login', {
      username: username.toLowerCase(),
      password: password,
    });
  }
  patientLogout(): void {
    localStorage.removeItem('patient');

    this.router.navigate(['/patient-login']);
  }

  patientIsLoggedIn(): boolean {
    return localStorage.getItem('patient') != null;
  }
}
