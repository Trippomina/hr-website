import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrEmployeesPageComponent } from './hr-employees-page.component';

describe('HrEmployeesPageComponent', () => {
  let component: HrEmployeesPageComponent;
  let fixture: ComponentFixture<HrEmployeesPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HrEmployeesPageComponent]
    });
    fixture = TestBed.createComponent(HrEmployeesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
