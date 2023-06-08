import { initialEmployeeState } from '../reducers/employee.reducers';
import { EmployeeState } from './employee.state';

export interface AppState {
  employee: EmployeeState;
}

export const initialState: AppState = {
  employee: initialEmployeeState
}