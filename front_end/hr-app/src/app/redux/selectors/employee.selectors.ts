import { createSelector } from '@ngrx/store';
import { AppState } from '../state/app.state';
import { EmployeeState } from '../state/employee.state';

// Select the employee state from the overall application state
export const selectEmployeeState = (state: AppState) => state.employees;

// Select the employees array from the employee state
export const selectEmployees = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.employees;}
);

// Select the current employee array from the employee state
export const selectCurrentEmployee = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.CurrentEmploye;}
);

export const selectLoadingList = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.loadingList;}
);

export const selectLoadingAddUpdate = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.loadingAddUpdate;}
);

export const selectMessage = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.message;}
);