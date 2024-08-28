import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePrescriptionFormComponent } from './update-prescription-form.component';

describe('UpdatePrescriptionFormComponent', () => {
  let component: UpdatePrescriptionFormComponent;
  let fixture: ComponentFixture<UpdatePrescriptionFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatePrescriptionFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatePrescriptionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
