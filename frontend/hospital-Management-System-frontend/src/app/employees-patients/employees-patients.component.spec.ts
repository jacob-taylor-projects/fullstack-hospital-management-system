import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesPatientsComponent } from './employees-patients.component';

describe('EmployeesPatientsComponent', () => {
  let component: EmployeesPatientsComponent;
  let fixture: ComponentFixture<EmployeesPatientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeesPatientsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeesPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
