import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesAppointmentsComponent } from './employees-appointments.component';

describe('EmployeesAppointmentsComponent', () => {
  let component: EmployeesAppointmentsComponent;
  let fixture: ComponentFixture<EmployeesAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeesAppointmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeesAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
