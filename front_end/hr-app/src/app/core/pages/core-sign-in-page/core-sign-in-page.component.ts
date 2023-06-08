import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { getEmployee } from 'src/app/redux/actions/employee.actions';
import { AppState } from 'src/app/redux/state/app.state';
import { Observable } from 'rxjs';
import { EmployeeIn } from 'src/app/shared/models/in/employee-in.model';
import { selectEmployee, selectLoading } from '../../selectors/selectors';
@Component({
  selector: 'app-core-sign-in-page',
  templateUrl: './core-sign-in-page.component.html',
  styleUrls: ['./core-sign-in-page.component.css']
})
export class CoreSignInPageComponent implements OnInit{
    employee$!: Observable<EmployeeIn>;
    loading$!: Observable<boolean>;
    error$!: Observable<any>;
    loading: boolean  = false;
    
    email: string = "";

    constructor(private store: Store<AppState>){}

    ngOnInit(): void {
      this.store.pipe(select(selectLoading)).subscribe(
        value => console.log(value));

      this.store.pipe(select(selectEmployee)).subscribe(
        value => console.log(value.email)
      );


      // this.loading$ = this.store.pipe(select(selectLoading));
      // this.error$ = this.store.pipe(select(selectError));
    }


    emailHandler(event: any): void{
      this.email  = event.target.value;
    }

    signInHandler(event: any): void{
      event.preventDefault();
      this.store.dispatch(getEmployee({email: this.email}));
    }
}
