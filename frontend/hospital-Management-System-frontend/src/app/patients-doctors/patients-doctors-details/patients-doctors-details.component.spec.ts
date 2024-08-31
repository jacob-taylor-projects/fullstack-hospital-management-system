import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientsDoctorsDetailsComponent } from './patients-doctors-details.component';

describe('PatientsDoctorsDetailsComponent', () => {
  let component: PatientsDoctorsDetailsComponent;
  let fixture: ComponentFixture<PatientsDoctorsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientsDoctorsDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientsDoctorsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
