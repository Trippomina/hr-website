import { Component, OnInit } from '@angular/core';
import { Employee } from './shared/models/employee.model'; 
import { EmployeeService } from './shared/services/employees-service.service'; 
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hr-app';
}

