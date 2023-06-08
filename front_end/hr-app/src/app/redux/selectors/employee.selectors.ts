import { createSelector } from '@ngrx/store';
import { AppState } from '../state/app.state';
import { EmployeeState } from '../state/employee.state';



// Select the employee state from the overall application state
export const selectEmployeeState = (state: AppState) => state.employee;

// Select the employees array from the employee state
export const selectEmployee = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.employee;}
);

// Select the current employee array from the employee state
export const selectLoading = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.loading;}
);

export const selectError = createSelector(
    selectEmployeeState,
    (state: EmployeeState) => {return state.error;}
);

// export const selectLoadingAddUpdate = createSelector(
//     selectEmployeeState,
//     (state: EmployeeState) => {return state.loadingAddUpdate;}
// );

// export const selectMessage = createSelector(
//     selectEmployeeState,
//     (state: EmployeeState) => {return state.message;}
// );