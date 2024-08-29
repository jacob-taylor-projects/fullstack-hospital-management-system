import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import ProcedureDTO from '../../models/ProcedureDTO';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';

@Component({
  selector: 'app-update-procedure-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './update-procedure-form.component.html',
  styleUrl: './update-procedure-form.component.css'
})
export class UpdateProcedureFormComponent {
  @Input()
  procedure!: ProcedureDTO;
  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  submitted = false;
  employee: BasicEmployeeDTO | undefined;
  patients: BasicPatientDTO[] = [];
  
  showUpdateOverlay = true;

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

  onUpdate(form: any): void {
    this.submitted = true;
    this.procedure.name = form.name;
    this.procedure.description = form.description;
    this.procedure.doctor = form.doctor;
    this.procedureService.getPatientDetails(form.patient.id).subscribe((patient: BasicPatientDTO) => {
      this.procedure.patient = patient;
    });
    // Assign other properties as needed

    this.procedureService.updateProcedure(this.procedure.id, this.procedure).subscribe(
      (response) => {
        console.log(response);
        this.submitted = false;
        this.updateUserOverlayVisibility.emit();
      },
      (error) => {
        console.error(error);
      }
    );
  }
  onCloseUpdateOverlay() {
    this.showUpdateOverlay = false;
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
    this.onClose.emit(); // Emit the onClose event
  }
  
  @Output() onClose = new EventEmitter<any>();
}
