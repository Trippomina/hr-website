// employee.reducer.ts

import { createReducer, on } from '@ngrx/store';
import { addEmployee, addEmployeeFailure, addEmployeeSuccess, getAllEmployees, getAllEmployeesFailure, getAllEmployeesSuccess, updateEmployee, updateEmployeeFailure, updateEmployeeSuccess } from '../actions/employee.actions';
import { EmployeeState } from '../state/employee.state';



const initialState: EmployeeState = {
  employees: [],
  CurrentEmploye: {id:"",fullName:"",department: "", email: "", address: ""},
  loadingAddUpdate: false,
  loadingList: false,
  message: "",
};

export const employeeReducer = createReducer(
  initialState,
  on(getAllEmployees, (state) => ({ ...state, loadingList: true, error: null })),
  on(getAllEmployeesSuccess, (state, { employees }) => ({ ...state, employees, loadingList: false })),
  on(getAllEmployeesFailure, (state, { error }) => ({ ...state, loadingList: false, message:"Failed to retrieve employees" })),
  on(addEmployee, (state) => ({ ...state, loadingAddUpdate: true, error: null })),
  on(addEmployeeSuccess, (state, { employee }) => ({ ...state, CurrentEmploye: employee, loadingAddUpdate: false, message:"Employee ["+employee.fullName+"] has been added successfully" })),
  on(addEmployeeFailure, (state, { error }) => ({ ...state, loadingAddUpdate: false, message:"Failed to add employee" })),
  on(updateEmployee, (state) => ({ ...state, loadingAddUpdate: true, error: null })),
  on(updateEmployeeSuccess, (state, { employee }) => ({ ...state, CurrentEmploye: employee, loadingAddUpdate: false, message:"Employee ["+employee.fullName+"] has been updated successfully" })),
  on(updateEmployeeFailure, (state, { error }) => ({ ...state, loadingAddUpdate: false, message:"Failed to update employee" })),
);
