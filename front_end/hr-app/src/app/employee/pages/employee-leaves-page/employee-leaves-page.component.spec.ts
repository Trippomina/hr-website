import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeLeavesPageComponent } from './employee-leaves-page.component';

describe('EmployeeLeavesPageComponent', () => {
  let component: EmployeeLeavesPageComponent;
  let fixture: ComponentFixture<EmployeeLeavesPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeLeavesPageComponent]
    });
    fixture = TestBed.createComponent(EmployeeLeavesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
