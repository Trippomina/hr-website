// employee.state.ts

import { Employee } from "src/app/shared/models/employee.model";

export interface EmployeeState {
  employees: Employee[];
  CurrentEmploye: Employee;
  loadingAddUpdate: boolean;
  loadingList: boolean;
  message: string;
}