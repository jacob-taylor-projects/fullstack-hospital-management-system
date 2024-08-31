import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientsPrescriptionsComponent } from './patients-prescriptions.component';

describe('PatientsPrescriptionsComponent', () => {
  let component: PatientsPrescriptionsComponent;
  let fixture: ComponentFixture<PatientsPrescriptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientsPrescriptionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientsPrescriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
