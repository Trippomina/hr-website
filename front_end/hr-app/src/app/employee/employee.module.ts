import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeInfoPageComponent } from './pages/employee-info-page/employee-info-page.component';
import { EmployeeLeavesPageComponent } from './pages/employee-leaves-page/employee-leaves-page.component';
import { EmployeeExpenseClaimsPageComponent } from './pages/employee-expense-claims-page/employee-expense-claims-page.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    EmployeeInfoPageComponent,
    EmployeeLeavesPageComponent,
    EmployeeExpenseClaimsPageComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    SharedModule
  ],
  exports:[
    EmployeeInfoPageComponent,
    EmployeeLeavesPageComponent,
    EmployeeExpenseClaimsPageComponent
  ]
})
export class EmployeeModule { }
