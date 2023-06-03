import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeesModuleRoutingModule } from './employees-module-routing.module';
import { EmployeesPageComponent } from './pages/employees-page/employees-page.component';
import { SharedModule } from '../shared/shared.module';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';



@NgModule({
  declarations: [
    EmployeesPageComponent,
    EmployeeFormComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    EmployeesModuleRoutingModule,
  ]
})
export class EmployeesModuleModule { }
