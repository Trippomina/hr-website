import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoreSignInPageComponent } from './core/pages/core-sign-in-page/core-sign-in-page.component';
import { EmployeeInfoPageComponent } from './employee/pages/employee-info-page/employee-info-page.component';
import { EmployeeLeavesPageComponent } from './employee/pages/employee-leaves-page/employee-leaves-page.component';
import { EmployeeExpenseClaimsPageComponent } from './employee/pages/employee-expense-claims-page/employee-expense-claims-page.component';
import { HrDashboardPageComponent } from './hr/pages/hr-dashboard-page/hr-dashboard-page.component';
import { HrEmployeesPageComponent } from './hr/pages/hr-employees-page/hr-employees-page.component';
import { HrLeavesPageComponent } from './hr/pages/hr-leaves-page/hr-leaves-page.component';
import { HrExpenseClaimsPageComponent } from './hr/pages/hr-expense-claims-page/hr-expense-claims-page.component';

const routes: Routes = [
  // Define your routes here
  // Example:
  { path: '', component: CoreSignInPageComponent },
  { path: 'employee/', component: EmployeeInfoPageComponent },
  { path: 'employee/leaves', component: EmployeeLeavesPageComponent },
  { path: 'employee/expense-claims', component: EmployeeExpenseClaimsPageComponent },
  { path: 'hr/', component: HrDashboardPageComponent },
  { path: 'hr/employees', component: HrEmployeesPageComponent },
  { path: 'hr/leaves', component: HrLeavesPageComponent },
  { path: 'hr/expense-claims', component: HrExpenseClaimsPageComponent }
  // { path: 'employees', component: EmployeesPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }