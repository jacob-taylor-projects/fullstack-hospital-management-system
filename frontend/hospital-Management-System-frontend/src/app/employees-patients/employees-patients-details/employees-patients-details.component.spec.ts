import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesPatientsDetailsComponent } from './employees-patients-details.component';

describe('EmployeesPatientsDetailsComponent', () => {
  let component: EmployeesPatientsDetailsComponent;
  let fixture: ComponentFixture<EmployeesPatientsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeesPatientsDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeesPatientsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
