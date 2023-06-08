import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SideNavComponent } from './components/side-nav/side-nav.component';
import { LayoutComponent } from './layout/layout.component';
import { AppRoutingModule } from '../app-routing.module';
import { CoreSignInPageComponent } from './pages/core-sign-in-page/core-sign-in-page.component';
import { StoreModule } from '@ngrx/store';
import { employeeReducer } from '../redux/reducers/employee.reducers';
import { EffectsModule } from '@ngrx/effects';
import { EmployeeEffects } from '../redux/effects/employee.effects';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    LayoutComponent,
    SideNavComponent,
    CoreSignInPageComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    SharedModule,
    StoreModule.forFeature('employees', employeeReducer),
    EffectsModule.forFeature([EmployeeEffects])
  ],
  exports:[
    LayoutComponent,
    CoreSignInPageComponent
  ]
})
export class CoreModule { }
