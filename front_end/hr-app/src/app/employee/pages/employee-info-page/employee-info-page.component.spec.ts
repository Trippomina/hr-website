import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInfoPageComponent } from './employee-info-page.component';

describe('EmployeeInfoPageComponent', () => {
  let component: EmployeeInfoPageComponent;
  let fixture: ComponentFixture<EmployeeInfoPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeInfoPageComponent]
    });
    fixture = TestBed.createComponent(EmployeeInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
