// import { HttpClient } from "@angular/common/http";
// import { EmployeeIn as Employee}  from "../models/in/employee-in.model"; 
// import { Injectable } from "@angular/core";
// import { Observable } from "rxjs";

// @Injectable({ providedIn: "root" })
// export class EmployeeService {
//   constructor(private readonly http: HttpClient) { }

//   getAllEmployees(): Observable<Employee[]> {
//     return this.http.get<Employee[]>("/employee/all");
//   }

//   addEmployee(employee: Partial<Employee>): Observable<Employee> {
//     return this.http
//       .post<Employee>("/employee/add", employee);
//   }

//   updateEmployee(employee: Partial<Employee>, id: string): Observable<Employee> {
//     return this.http
//       .put<Employee>("/employee/update/"+id, employee);
//   }

//   delete(): void {
//      this.http.delete('/employee/delete/f506b586-5c4d-49ce-91f3-755f2251a8bd')
//       .subscribe(
//         (response) => {
//           // Handle the response from the API
//           console.log(response);
//         },
//         (error) => {
//           // Handle any errors that occurred during the API request
//           console.error(error);
//         })
//       }

  
// }