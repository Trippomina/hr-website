import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import { catchError, map, mergeMap } from 'rxjs/operators';
import { EmployeeService } from 'src/app/shared/services/employee-service.service';
import { getEmployee, getEmployeeSuccess, getEmployeeFailure} from '../actions/employee.actions';
@Injectable()
export class EmployeeEffects {
  constructor(
    private actions$: Actions,
    private employeeService: EmployeeService
  ) { }

  getEmployee$ = createEffect(() =>
    this.actions$.pipe(
      ofType(getEmployee),
      mergeMap(({ email }) =>
        this.employeeService.getEmployeeByEmail(email).pipe(
          map((employee) => getEmployeeSuccess({ employee })),
          catchError((error) => of(getEmployeeFailure({ error })))
        )
      )
    )
  );

  // getAllEmployees$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(getAllEmployees),
  //     mergeMap(() =>
  //       this.employeeService.getAllEmployees().pipe(
  //         map((employees) => getAllEmployeesSuccess({ employees })),
  //         catchError((error) => of(getAllEmployeesFailure({ error })))
  //       )
  //     )
  //   )
  // );

  // addEmployee$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(addEmployee),
  //     mergeMap(({ employee }) =>
  //       this.employeeService.addEmployee(employee).pipe(
  //         map(() => addEmployeeSuccess({ employee })),
  //         catchError((error) => of(addEmployeeFailure({ error })))
  //       )
  //     )
  //   )
  // );

  // getAllEmployeesAfterAdd$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(addEmployeeSuccess),
  //     mergeMap(() => of(getAllEmployees()))
  //   )
  // );

  // updateEmployee$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(updateEmployee),
  //     mergeMap(({ employee, id }) =>
  //       this.employeeService.updateEmployee(employee, id).pipe(
  //         map(() => updateEmployeeSuccess({ employee })),
  //         catchError((error) => of(updateEmployeeFailure({ error })))
  //       )
  //     )
  //   )
  // );

  // getAllEmployeesAfterUpdate$ = createEffect(() =>
  //   this.actions$.pipe(
  //     ofType(updateEmployeeSuccess),
  //     mergeMap(() => of(getAllEmployees()))
  //   )
  // );
}