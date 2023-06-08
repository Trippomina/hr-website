import { createSelector, createFeatureSelector } from '@ngrx/store';
import { AppState } from 'src/app/redux/state/app.state';
    // Create a feature state selector
export const selectAppState = createFeatureSelector<AppState>('employees');


// Create a selector to retrieve a specific property from the feature state
export const selectLoading = createSelector(
  selectAppState,
  (state: AppState) => state.employee.loading
);

export const selectEmployee = createSelector(
  selectAppState,
  (state: AppState) => state.employee.employee
);

// // Create a selector to derive a computed value from the feature state
// export const selectFeatureCount = createSelector(
//   selectAppState,
//   (state: AppState) => state.data.length
// );