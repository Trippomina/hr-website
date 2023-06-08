import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HrRoutingModule } from './hr-routing.module';
import { HrDashboardPageComponent } from './pages/hr-dashboard-page/hr-dashboard-page.component';
import { HrEmployeesPageComponent } from './pages/hr-employees-page/hr-employees-page.component';
import { HrLeavesPageComponent } from './pages/hr-leaves-page/hr-leaves-page.component';
import { HrExpenseClaimsPageComponent } from './pages/hr-expense-claims-page/hr-expense-claims-page.component';
import { SharedModule } from '../shared/shared.module';
import { StoreModule } from '@ngrx/store';
import { employeeReducer } from '../redux/reducers/employee.reducers';
import { EffectsModule } from '@ngrx/effects';
import { EmployeeEffects } from '../redux/effects/employee.effects';


@NgModule({
  declarations: [
    HrDashboardPageComponent,
    HrEmployeesPageComponent,
    HrLeavesPageComponent,
    HrExpenseClaimsPageComponent
  ],
  imports: [
    CommonModule,
    HrRoutingModule,
    SharedModule,
    StoreModule.forFeature('employees', employeeReducer),
    EffectsModule.forFeature([EmployeeEffects])
  ],
  exports:[
    HrDashboardPageComponent,
    HrEmployeesPageComponent,
    HrLeavesPageComponent,
    HrExpenseClaimsPageComponent
  ]
})
export class HrModule { }
