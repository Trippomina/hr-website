import { map } from "rxjs/operators";
import { HttpClient } from "@angular/common/http";
import { Employee } from "../models/employee.model";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({ providedIn: "root" })
export class EmployeeService {
  constructor(private readonly http: HttpClient) { }

  getAll(): Observable<Employee[]> {
    return this.http.get<any[]>('/employee/all').pipe(
      map((data) => {
        return data.map((e) => new Employee(e.id, e.fullName, e.department, e.email, e.address));
      })
    );
  }

  create(employee: Partial<Employee>): Observable<Employee> {
    return this.http
      .post<Employee>("/employee/add", employee);
  }

  update(employee: Partial<Employee>, id: string): Observable<Employee> {
    return this.http
      .put<Employee>("/employee/update/"+id, employee);
  }

  delete(): void {
     this.http.delete('/employee/delete/f506b586-5c4d-49ce-91f3-755f2251a8bd')
      .subscribe(
        (response) => {
          // Handle the response from the API
          console.log(response);
        },
        (error) => {
          // Handle any errors that occurred during the API request
          console.error(error);
        })
      }

  
}