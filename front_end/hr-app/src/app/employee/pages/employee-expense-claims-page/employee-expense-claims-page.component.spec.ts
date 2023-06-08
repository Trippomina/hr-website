import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeExpenseClaimsPageComponent } from './employee-expense-claims-page.component';

describe('EmployeeExpenseClaimsPageComponent', () => {
  let component: EmployeeExpenseClaimsPageComponent;
  let fixture: ComponentFixture<EmployeeExpenseClaimsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeExpenseClaimsPageComponent]
    });
    fixture = TestBed.createComponent(EmployeeExpenseClaimsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
