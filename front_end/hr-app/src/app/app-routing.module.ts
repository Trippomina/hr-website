import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardPageComponent } from './dashboard-module/pages/dashboard-page/dashboard-page.component';
import { EmployeesPageComponent } from './employees-module/pages/employees-page/employees-page.component';

const routes: Routes = [
  // Define your routes here
  // Example:
  { path: '', component: DashboardPageComponent },
  { path: 'employees', component: EmployeesPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }