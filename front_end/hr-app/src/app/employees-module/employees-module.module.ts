import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { CommonModule } from '@angular/common';

import { EmployeesModuleRoutingModule } from './employees-module-routing.module';
import { EmployeesPageComponent } from './pages/employees-page/employees-page.component';



@NgModule({
  declarations: [
    EmployeesPageComponent
  ],
  imports: [
    CommonModule,
    EmployeesModuleRoutingModule,
    SharedModule
  ]
})
export class EmployeesModuleModule { }
