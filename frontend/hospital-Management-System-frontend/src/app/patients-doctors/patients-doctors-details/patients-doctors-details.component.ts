import { Component } from '@angular/core';
import FullEmployeeDTO from '../../models/FullEmployeeDTO';
import { GeneralService } from '../../../services/general.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patients-doctors-details',
  standalone: true,
  imports: [],
  templateUrl: './patients-doctors-details.component.html',
  styleUrl: './patients-doctors-details.component.css'
})
export class PatientsDoctorsDetailsComponent {
  employee!: FullEmployeeDTO;
  updateModalVisible = false;
  showUserOverlay = false;

  constructor(private employeeDetailsService: GeneralService, private route: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    localStorage.setItem("employeeId",id.toString());
    this.employeeDetailsService.getEmployeeDetails(id).subscribe((data:FullEmployeeDTO) => {
      this.employee = data;
    });
  }
  DoctorsPage(){
    this.router.navigate(["/patients-doctors"]);
  }
}
