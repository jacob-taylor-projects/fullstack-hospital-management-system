import { Component, EventEmitter, Output } from '@angular/core';
import PrescriptionDTO from '../../models/PrescriptionDTO';
import BasicEmployeeDTO from '../../models/BasicEmployeeDTO';
import BasicPatientDTO from '../../models/BasicPatientDTO';
import { GeneralService } from '../../../services/general.service';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-add-prescription-form',
  standalone: true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-prescription-form.component.html',
  styleUrl: './add-prescription-form.component.css'
})
export class AddPrescriptionFormComponent {
  prescription: PrescriptionDTO = {
    id: 0,
    name: '',
    description: '',
    prescriber: {
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
    prescribed: {
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

  onSubmit(form: any): void {
    this.submitted = true;
    this.prescription.name = form.name;
    this.prescription.description = form.description;
    this.prescription.prescriber= form.prescriber;
    this.prescriptionService.getPatientDetails(form.prescribed.id).subscribe((prescribed: BasicPatientDTO) => {
      this.prescription.prescribed = prescribed;
    });
    // Assign other properties as needed

    this.prescriptionService.createPrescription(this.prescription).subscribe(
      (response) => {
        console.log(response);
        this.prescription = {
          id: 0,
          name: '',
          description: '',
          prescriber: {
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
          prescribed: {
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
      },
      (error) => {
        console.error(error);
      }
    );
  }

  handleOverlayExit() {
    this.updateUserOverlayVisibility.emit();
  }
}
