import { Component } from '@angular/core';
import { catchError, of, takeUntil } from 'rxjs';
import { Employee } from '../../models/employee.model';
import { EmployeeService } from '../../services/employees-service.service';

@Component({
  selector: 'app-employees-page',
  templateUrl: './employees-page.component.html',
  styleUrls: ['./employees-page.component.css']
})
export class EmployeesPageComponent {
  message: string = "";
  status: string = "Empoyees";
  formOnDisplay: boolean = false;
  waitingResponse: boolean = false;
  loading: boolean = false;
  employees: Employee[] = [];
  employee: Employee = new Employee("","", "", "", "");
  selectedEmployeeId: string="";
  fullName: string = "";
  department: string = "IT";
  email: string = "";
  address: string = "";
  fullNameError: string = "";
  emailError: string = "";
  addressError: string = "";


  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.switchLoading();
    this.employeeService.getAll().pipe(
      catchError((error) => {
        console.error(error);
        this.message = "Failed to load employees.";
        this.switchLoading();
        return of([]);
      })
    ).subscribe(
      (employees: Employee[]) => {
        employees.sort((a, b) => a.fullName.localeCompare(b.fullName));
        this.employees = employees;
        this.switchLoading();
      }
    );
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
      this.employee.fullName = this.fullName;
      this.employee.department = this.department;
      this.employee.email = this.email;
      this.employee.address = this.address;
      if(this.status === "Add Employee"){
        this.add();
      }
      if(this.status === "Update Employee"){
        this.update();
      }
      
      this.switchWaitingResponse();
      this.resetForm();
      this.switchFormOnDisplay("Employees");
    }
  }

  updateHandler(event: any,employee: Employee):void{
    event.preventDefault();
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
    this.employee.address = "";
    this.employee.department = "";
    this.employee.email = "";
    this.employee.fullName = "";
    this.employee.id = "";
  }



  //rest calls
  add(): void {
    this.employeeService
      .create(this.employee)
      .pipe()
      .subscribe({
        next: (res) => {this.switchWaitingResponse(); this.message = "Employee [" + res.fullName + "] has been added Successfully"; },
        error: (err) => {
          console.log(err);
          this.message = "Failed to add employee.";
          this.switchWaitingResponse();
        },
      });
  }

    update(): void {
      this.employeeService
        .update(this.employee,this.selectedEmployeeId)
        .pipe()
        .subscribe({
          next: (res) => {this.switchWaitingResponse(); this.message = "Employee [" + res.fullName + "] has been updated Successfully"; },
          error: (err) => {
            console.log(err);
            this.message = "Failed to add employee.";
            this.switchWaitingResponse();
          },
        });
    }


}
