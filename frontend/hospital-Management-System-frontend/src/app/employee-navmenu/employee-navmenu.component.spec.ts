import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeNavmenuComponent } from './employee-navmenu.component';

describe('EmployeeNavmenuComponent', () => {
  let component: EmployeeNavmenuComponent;
  let fixture: ComponentFixture<EmployeeNavmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeNavmenuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeeNavmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
