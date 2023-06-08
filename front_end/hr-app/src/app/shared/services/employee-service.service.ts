import { HttpClient } from "@angular/common/http";
import { EmployeeIn as Employee}  from "../models/in/employee-in.model"; 
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({ providedIn: "root" })
export class EmployeeService {
  constructor(private readonly http: HttpClient) { }

  PATH: string = "/employee";

  getEmployeeByEmail(email: string): Observable<Employee>{
    return this.http.get<Employee>("/login/"+email);
  }

}