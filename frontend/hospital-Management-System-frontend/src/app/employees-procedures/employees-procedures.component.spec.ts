import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesProceduresComponent } from './employees-procedures.component';

describe('EmployeesProceduresComponent', () => {
  let component: EmployeesProceduresComponent;
  let fixture: ComponentFixture<EmployeesProceduresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeesProceduresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeesProceduresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
