import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientsProceduresComponent } from './patients-procedures.component';

describe('PatientsProceduresComponent', () => {
  let component: PatientsProceduresComponent;
  let fixture: ComponentFixture<PatientsProceduresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientsProceduresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientsProceduresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
