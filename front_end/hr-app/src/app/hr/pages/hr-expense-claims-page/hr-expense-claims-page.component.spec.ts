import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrExpenseClaimsPageComponent } from './hr-expense-claims-page.component';

describe('HrExpenseClaimsPageComponent', () => {
  let component: HrExpenseClaimsPageComponent;
  let fixture: ComponentFixture<HrExpenseClaimsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HrExpenseClaimsPageComponent]
    });
    fixture = TestBed.createComponent(HrExpenseClaimsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
