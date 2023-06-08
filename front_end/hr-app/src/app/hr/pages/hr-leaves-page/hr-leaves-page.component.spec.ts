import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrLeavesPageComponent } from './hr-leaves-page.component';

describe('HrLeavesPageComponent', () => {
  let component: HrLeavesPageComponent;
  let fixture: ComponentFixture<HrLeavesPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HrLeavesPageComponent]
    });
    fixture = TestBed.createComponent(HrLeavesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
