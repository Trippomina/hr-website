import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CircularLoadingComponent } from './circular-loading.component';

describe('CircularLoadingComponent', () => {
  let component: CircularLoadingComponent;
  let fixture: ComponentFixture<CircularLoadingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CircularLoadingComponent]
    });
    fixture = TestBed.createComponent(CircularLoadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
