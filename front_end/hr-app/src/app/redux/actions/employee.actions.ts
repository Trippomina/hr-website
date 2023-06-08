// employee.actions.ts

import { createAction, props } from '@ngrx/store';
import { EmployeeIn } from 'src/app/shared/models/in/employee-in.model'; 

// export const getAllEmployees = createAction('[Employee] Get All Employees');
// export const getAllEmployeesSuccess = createAction('[Employee] Get All Employees Success', props<{ employees: Employee[] }>());
// export const getAllEmployeesFailure = createAction('[Employee] Get All Employees Failure', props<{ error: any }>());

// export const addEmployee = createAction('[Employee] Add Employee',props<{employee: Employee}>());
// export const addEmployeeSuccess = createAction('[Employee] Add Employee Success', props<{ employee: Employee }>());
// export const addEmployeeFailure = createAction('[Employee] Add Employee Failure', props<{ error: any }>());

// export const updateEmployee = createAction('[Employee] Update Employee',props<{employee: Employee, id: string}>());
// export const updateEmployeeSuccess = createAction('[Employee] Update Employee Success', props<{ employee: Employee }>());
// export const updateEmployeeFailure = createAction('[Employee] Update Employee Failure', props<{ error: any }>());
// Define other actions

export const getEmployee = createAction('[EmployeeIn] Get Employee', props<{email: string}>());
export const getEmployeeSuccess = createAction('[EmployeeIn] Get Employee Success', props<{ employee: EmployeeIn }>());
export const getEmployeeFailure = createAction('[EmployeeIn] Get Employee Failure', props<{ error: any }>());
