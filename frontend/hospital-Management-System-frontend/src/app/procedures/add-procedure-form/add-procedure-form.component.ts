import { NgFor } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import ProcedureDTO from '../../models/ProcedureDTO';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';

@Component({
  selector: 'app-add-procedure-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-procedure-form.component.html',
  styleUrl: './add-procedure-form.component.css'
})
export class AddProcedureFormComponent {
  procedure: ProcedureDTO = {
    id: 0,
    name: '',
    description: '',
    doctor: {
      id: 0,
      profile: {
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
      },
      age: 0,
      gender: '',
      address: '',
      admin: false,
      doctor: false,
      specialty: '',
      salary: 0,
    },
    patient: {
      id: 0,
      profile: {
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
      },
      age: 0,
      gender: '',
      address: '',
      prognosis: '',
    },
  };

  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  submitted = false;
  employee: BasicEmployeeDTO | undefined;
  patients: BasicPatientDTO[] = [];

  

  constructor(private procedureService: GeneralService) { }

  ngOnInit(): void {
    this.employee = localStorage.getItem("employee") ? JSON.parse(localStorage.getItem("employee")!) : undefined;
    this.procedureService.getPatients().subscribe(
      (patients) => {
        this.patients = patients;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  onSubmit(form: any): void {
    this.submitted = true;
    this.procedure.name = form.name;
    this.procedure.description = form.description;
    this.procedure.doctor= form.doctor;
    this.procedureService.getPatientDetails(form.patient.id).subscribe((patient: BasicPatientDTO) => {
      this.procedure.patient = patient;
    });
    // Assign other properties as needed

    this.procedureService.createProcedure(this.procedure).subscribe(
      (response) => {
        console.log(response);
        this.procedure= {
          id: 0,
          name: '',
          description: '',
          doctor: {
            id: 0,
            profile: {
              firstName: '',
              lastName: '',
              email: '',
              phoneNumber: '',
            },
            age: 0,
            gender: '',
            address: '',
            admin: false,
            doctor: false,
            specialty: '',
            salary: 0,
          },
          patient: {
            id: 0,
            profile: {
              firstName: '',
              lastName: '',
              email: '',
              phoneNumber: '',
            },
            age: 0,
            gender: '',
            address: '',
            prognosis: '',
          },
        };
        this.submitted = false;
        window.location.reload();
        this.updateUserOverlayVisibility.emit();
      },
      (error) => {
        console.error(error);
      }, 
      
    );
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
  }
}
