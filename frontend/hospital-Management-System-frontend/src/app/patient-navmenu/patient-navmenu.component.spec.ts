import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientNavmenuComponent } from './patient-navmenu.component';

describe('PatientNavmenuComponent', () => {
  let component: PatientNavmenuComponent;
  let fixture: ComponentFixture<PatientNavmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientNavmenuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientNavmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
