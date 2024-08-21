import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeRegistryFormComponent } from './employee-registry-form.component';

describe('EmployeeRegistryFormComponent', () => {
  let component: EmployeeRegistryFormComponent;
  let fixture: ComponentFixture<EmployeeRegistryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeRegistryFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeeRegistryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
