import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeesRoutingModule } from './employees-routing.module';
import { EmployeesPageComponent } from './pages/employees-page/employees-page.component';
import { SharedModule } from '../shared/shared.module';
import { StoreModule } from '@ngrx/store';
import { employeeReducer } from '../redux/reducers/employee.reducers';
import { EffectsModule } from '@ngrx/effects';
import { EmployeeEffects } from '../redux/effects/employee.effects';


@NgModule({
  declarations: [
    EmployeesPageComponent
  ],
  imports: [
    CommonModule,
    EmployeesRoutingModule,
    SharedModule,
    StoreModule.forFeature('employees', employeeReducer),
    EffectsModule.forFeature([EmployeeEffects])

  ]
})
export class EmployeesModule { }
