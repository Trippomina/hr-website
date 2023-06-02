import { Component, OnInit } from '@angular/core';
import { Employee } from './core/models/employee.model';
import { EmployeeService } from './core/services/employees.services';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'hr-app';
  message: string = "";
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.getAll().pipe(
      catchError((error) => {
        // Handle any errors that occurred during the API request
        console.error(error);
        this.message = "failed";
        // Return an empty array or an appropriate default value
        return of([]);
      })
    ).subscribe(
      (employees: Employee[]) => {
        this.employees = employees;
        console.log(this.employees[0].fullName);
        // Perform any additional operations with the employee data
      }
    );
  }
}

