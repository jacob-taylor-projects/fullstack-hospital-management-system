import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAppointmentFormComponent } from './update-appointment-form.component';

describe('UpdateAppointmentFormComponent', () => {
  let component: UpdateAppointmentFormComponent;
  let fixture: ComponentFixture<UpdateAppointmentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateAppointmentFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateAppointmentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
