import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import { AppState } from 'src/app/redux/state/app.state';
import { Store, select } from '@ngrx/store';
import { selectEmployee, selectLoading } from 'src/app/redux/selectors/employee.selectors';
import { EmployeeIn } from 'src/app/shared/models/in/employee-in.model';
import { getEmployee } from 'src/app/redux/actions/employee.actions';
@Component({
  selector: 'app-hr-dashboard-page',
  templateUrl: './hr-dashboard-page.component.html',
  styleUrls: ['./hr-dashboard-page.component.css']
})
export class HrDashboardPageComponent implements OnInit{
  loading$! : Observable<boolean>;
  employee$! : Observable<EmployeeIn>
  
    constructor(private store: Store<AppState>){}

  ngOnInit(): void {
    this.employee$ = this.store.pipe(select(selectEmployee));
    this.loading$ = this.store.pipe(select(selectLoading));
    this.store.dispatch(getEmployee({email: "ahmed@example.com"}));
    console.log("hi");
  }
}
