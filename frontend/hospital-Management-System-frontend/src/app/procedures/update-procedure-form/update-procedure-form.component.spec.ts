import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProcedureFormComponent } from './update-procedure-form.component';

describe('UpdateProcedureFormComponent', () => {
  let component: UpdateProcedureFormComponent;
  let fixture: ComponentFixture<UpdateProcedureFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateProcedureFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateProcedureFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
