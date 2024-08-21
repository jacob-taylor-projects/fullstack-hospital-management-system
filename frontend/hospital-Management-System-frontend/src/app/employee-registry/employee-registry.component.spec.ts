import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeRegistryComponent } from './employee-registry.component';

describe('EmployeeRegistryComponent', () => {
  let component: EmployeeRegistryComponent;
  let fixture: ComponentFixture<EmployeeRegistryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeRegistryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeeRegistryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
