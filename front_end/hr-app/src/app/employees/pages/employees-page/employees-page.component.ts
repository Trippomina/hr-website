import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { addEmployee, getAllEmployees, updateEmployee } from 'src/app/redux/actions/employee.actions';
import { selectCurrentEmployee, selectEmployees, selectLoadingAddUpdate, selectLoadingList, selectMessage } from 'src/app/redux/selectors/employee.selectors';
import { AppState } from 'src/app/redux/state/app.state';
import { Employee } from 'src/app/shared/models/employee.model';


@Component({
  selector: 'app-employees-page',
  templateUrl: './employees-page.component.html',
  styleUrls: ['./employees-page.component.css']
})
export class EmployeesPageComponent implements OnInit{

  employees$!: Observable<Employee[]>;
  employee$!: Observable<Employee>;
  loadingList$!: Observable<boolean>;
  loadingAddUpdate$!: Observable<boolean>;
  message$!: Observable<string>;
  constructor(private store: Store<AppState>) {}

  message: string = "";
  status: string = "Empoyees";
  formOnDisplay: boolean = false;
  waitingResponse: boolean = false;
  loading: boolean = false;
  selectedEmployeeId: string="";
  fullName: string = "";
  department: string = "IT";
  email: string = "";
  address: string = "";
  fullNameError: string = "";
  emailError: string = "";
  addressError: string = "";



  ngOnInit() {
    this.switchLoading();
    this.employees$ = this.store.pipe(select(selectEmployees));
    this.employee$ = this.store.pipe(select(selectCurrentEmployee));
    this.loadingList$ = this.store.pipe(select(selectLoadingList));
    this.loadingAddUpdate$ = this.store.pipe(select(selectLoadingAddUpdate));
    this.message$ = this.store.pipe(select(selectMessage));
    this.store.pipe(select(selectEmployees)).subscribe(list => {
      if (list.length === 0) {
        this.store.dispatch(getAllEmployees());
      }
    });
  }

  //boolean switchs
  switchFormOnDisplay(status: string): void {
    this.formOnDisplay = !this.formOnDisplay;
    this.status = status;
    this.resetForm();
  }

  switchWaitingResponse(): void {
    this.waitingResponse = !this.waitingResponse;
  }

  switchLoading(): void {
    this.loading = !this.loading;
  }

  //fields handlers
  handleFullNameChange(event: any) {
    this.fullName = event.target.value;
    if (this.fullName.trim() !== '') {
      this.fullNameError = "";
    }
  }

  handleDepartmentChange(event: any) {
    this.department = event.target.value;
  }


  handleEmailChange(event: any) {
    this.email = event.target.value;
    if (this.email.trim() === '') {
      this.emailError = 'Email cannot be empty.';
    } else if (!this.isValidEmail(this.email)) {
      this.emailError = 'Invalid email format.';
    } else {
      this.emailError = '';
    }
  }

  isValidEmail(email: string): boolean {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }

  handleAddressChange(event: any) {
    this.address = event.target.value;
    if (this.address.trim() !== '') {
      this.addressError = "";
    }
  }

  handleConfirm(event: Event) {
    event.preventDefault();
    if (this.fullName.trim() === '') {
      this.fullNameError = 'Full Name cannot be empty.';
    }
    if (this.email.trim() === '') {
      this.emailError = 'Email cannot be empty.';
    }
    if (!this.isValidEmail(this.email)) {
      this.emailError = 'Invalid email format.';
    }
    if (this.address.trim().length < 5) {
      this.addressError = '5 characters minimum';
    }
    if (this.fullName.trim() !== '' && this.email.trim() !== '' && this.isValidEmail(this.email), this.address.trim().length > 5) {
      const employee: Employee = {id:this.selectedEmployeeId,fullName:this.fullName,department: this.department, email: this.email, address: this.address};
      if(this.status === "Add Employee"){
        this.store.dispatch(addEmployee({employee}));
        this.store.select(selectMessage).subscribe(data=>{this.message = data});
      }
      if(this.status === "Update Employee"){
        this.store.dispatch(updateEmployee({employee: employee, id: this.selectedEmployeeId}));
        this.store.select(selectMessage).subscribe(data=>{this.message = data});
      }
      this.switchWaitingResponse();
      this.resetForm();
      this.switchFormOnDisplay("Employees");
    }
  }

  updateHandler(event: any,employee: Employee,target: HTMLElement):void{
    event.preventDefault();
    target.scrollIntoView();
    console.log(event.target.value);
    this.selectedEmployeeId = event.target.value;
    this.switchFormOnDisplay("Update Employee");
    this.fullName = employee.fullName;
    this.address = employee.address;
    this.email = employee.email;
    this.department = employee.department;
  }

  resetForm() {
    this.fullName = '';
    this.department = 'IT';
    this.email = '';
    this.address = '';
    this.fullNameError = '';
    this.emailError = '';
    this.addressError = '';
    this.message = '';
  }

}
