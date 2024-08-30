import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import FullEmployeeDTO from '../app/models/FullEmployeeDTO';
import FullPatientDTO from '../app/models/FullPatientDTO';
import PrescriptionDTO from '../app/models/PrescriptionDTO';
import ProcedureDTO from '../app/models/ProcedureDTO';
import AppointmentDTO from '../app/models/AppointmentDTO';

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

  companyId=localStorage.getItem("companyId");
  private apiUrl = `http://localhost:8080/company/${this.companyId}/employee`;


  getEmployeeDetails(id: number):Observable<FullEmployeeDTO> {
    return this.http.get<FullEmployeeDTO>(`${this.apiUrl}/${id}`);
  }
  deleteEmployee(id: number) {
    return this.http.delete(`http://localhost:8080/company/${this.companyId}/employee/${id}`);
  }

  updateEmployee(id: number, updatedEmployee: any): Observable<any> {
    return this.http.put(`http://localhost:8080/company/${this.companyId}/employee/${id}`, updatedEmployee);
  }

  private patientUrl = `http://localhost:8080/company/${this.companyId}/patient`;

  

  

  getPatients(): Observable<any> {
    return this.http.get(`http://localhost:8080/company/${this.companyId}/patients`);
  }


  getPatientDetails(id: number):Observable<FullPatientDTO> {
    return this.http.get<FullPatientDTO>(`${this.patientUrl}/${id}`);
  }
  deletePatient(id: number) {
    return this.http.delete(`http://localhost:8080/company/${this.companyId}/patient/${id}`);
  }

  updatePatient(id: number, updatedPatient: any): Observable<any> {
    return this.http.put(`http://localhost:8080/company/${this.companyId}/patient/${id}`, updatedPatient);
  }

  
  private prescriptionUrl = `http://localhost:8080/company/${this.companyId}/prescription`; // replace with your API URL

  

  createPrescription(prescription: PrescriptionDTO): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post(this.prescriptionUrl, prescription, { headers });
  }

  getPrescriptions(): Observable<PrescriptionDTO[]> {
    return this.http.get<PrescriptionDTO[]>(this.apiUrl);
  }

  updatePrescription(id:number,prescription: PrescriptionDTO): Observable<any> {
    return this.http.put(`${this.prescriptionUrl}/${prescription.id}`, prescription);
  }

  deletePrescription(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
private procedureUrl = `http://localhost:8080/company/${this.companyId}/procedure`
  
  createProcedure(procedure: ProcedureDTO): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post(this.procedureUrl, procedure, { headers });
  }

  

  updateProcedure(id:number,procedure: ProcedureDTO): Observable<any> {
    return this.http.put(`${this.procedureUrl}/${procedure.id}`, procedure);
  }

  deleteProcedure(id: number): Observable<any> {
    return this.http.delete(`${this.procedureUrl}/${id}`);
  }

  private appointmentUrl = `http://localhost:8080/company/${this.companyId}/appointment`
  
  createAppointment(appointment: AppointmentDTO): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post(this.appointmentUrl, appointment, { headers });
  }

  

  updateAppointment(id:number,appointment: AppointmentDTO): Observable<any> {
    return this.http.put(`${this.appointmentUrl}/${appointment.id}`, appointment);
  }

  deleteAppointment(id: number): Observable<any> {
    return this.http.delete(`${this.appointmentUrl}/${id}`);
  }


}
