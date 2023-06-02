import { map } from "rxjs/operators";
import { HttpClient } from "@angular/common/http";
import { Employee } from "../models/employee.model";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({ providedIn: "root" })
export class EmployeeService{
  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Employee[]> {
    return this.http.get<any[]>('/employee/all').pipe(
      map((data) => {
        return data.map((e) => new Employee(e.d, e.fullName,e.department,e.email,e.address));
      })
    );
  }

}