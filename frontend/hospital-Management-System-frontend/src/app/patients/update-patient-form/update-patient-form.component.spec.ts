import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePatientFormComponent } from './update-patient-form.component';

describe('UpdatePatientFormComponent', () => {
  let component: UpdatePatientFormComponent;
  let fixture: ComponentFixture<UpdatePatientFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatePatientFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatePatientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
