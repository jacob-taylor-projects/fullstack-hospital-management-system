import { Component, EventEmitter, Input, Output } from '@angular/core';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';
import PrescriptionDTO from '../../models/PrescriptionDTO';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-update-prescription-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './update-prescription-form.component.html',
  styleUrl: './update-prescription-form.component.css'
})
export class UpdatePrescriptionFormComponent {
  @Input()
  prescription!: PrescriptionDTO;
  @Output() updateUserOverlayVisibility = new EventEmitter<any>();

  submitted = false;
  employee: BasicEmployeeDTO | undefined;
  patients: BasicPatientDTO[] = [];
  
  showUpdateOverlay = true;

  constructor(private prescriptionService: GeneralService) { }

  ngOnInit(): void {
    this.employee = localStorage.getItem("employee") ? JSON.parse(localStorage.getItem("employee")!) : undefined;
    this.prescriptionService.getPatients().subscribe(
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
    this.prescription.name = form.name;
    this.prescription.description = form.description;
    this.prescription.prescriber = form.prescriber;
    this.prescriptionService.getPatientDetails(form.prescribed.id).subscribe((prescribed: BasicPatientDTO) => {
      this.prescription.prescribed = prescribed;
    });
    // Assign other properties as needed

    this.prescriptionService.updatePrescription(this.prescription.id, this.prescription).subscribe(
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
