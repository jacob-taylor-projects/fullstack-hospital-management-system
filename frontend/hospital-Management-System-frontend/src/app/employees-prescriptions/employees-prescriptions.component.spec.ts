import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesPrescriptionsComponent } from './employees-prescriptions.component';

describe('EmployeesPrescriptionsComponent', () => {
  let component: EmployeesPrescriptionsComponent;
  let fixture: ComponentFixture<EmployeesPrescriptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeesPrescriptionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeesPrescriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
