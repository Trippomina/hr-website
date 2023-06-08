import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrDashboardPageComponent } from './hr-dashboard-page.component';

describe('HrDashboardPageComponent', () => {
  let component: HrDashboardPageComponent;
  let fixture: ComponentFixture<HrDashboardPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HrDashboardPageComponent]
    });
    fixture = TestBed.createComponent(HrDashboardPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
