import { Component, Input } from '@angular/core';
import { GeneralService } from '../../../services/general.service';
import { ActivatedRoute } from '@angular/router';
import FullEmployeeDTO from '../../models/FullEmployeeDTO';

@Component({
  selector: 'app-employee-card',
  standalone: true,
  imports: [],
  templateUrl: './employee-card.component.html',
  styleUrl: './employee-card.component.css'
})
export class EmployeeCardComponent {
  @Input()
  employee!: FullEmployeeDTO;
}
