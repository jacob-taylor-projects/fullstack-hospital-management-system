import { Component, Input } from '@angular/core';
import FullPatientDTO from '../../models/FullPatientDTO';

@Component({
  selector: 'app-patient-card',
  standalone: true,
  imports: [],
  templateUrl: './patient-card.component.html',
  styleUrl: './patient-card.component.css'
})
export class PatientCardComponent {
  @Input()
  patient!: FullPatientDTO;
}
