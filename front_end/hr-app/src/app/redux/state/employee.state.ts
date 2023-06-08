import { EmployeeIn } from "src/app/shared/models/in/employee-in.model"; 

export interface EmployeeState {
  employee: EmployeeIn;
  loading: boolean;
  error: any;
}