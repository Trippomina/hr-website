import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoreSignInPageComponent } from './core-sign-in-page.component';

describe('CoreSignInPageComponent', () => {
  let component: CoreSignInPageComponent;
  let fixture: ComponentFixture<CoreSignInPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoreSignInPageComponent]
    });
    fixture = TestBed.createComponent(CoreSignInPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
