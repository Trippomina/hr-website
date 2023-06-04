import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ErrorInterceptor } from './core/interceptors/error.interceptor';
import { ApiInterceptor } from './core/interceptors/api.interceptor';
import { AppRoutingModule } from './app-routing.module';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { EffectsModule } from '@ngrx/effects';
import { EmployeeEffects } from './redux/effects/employee.effects';
import { employeeReducer } from './redux/reducers/employee.reducers';
import { EmployeesModule } from './employees/employees.module';
import { StoreModule } from '@ngrx/store';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CoreModule,
    SharedModule,
    StoreModule.forRoot({employees : employeeReducer}),
    EffectsModule.forRoot([EmployeeEffects]),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: ApiInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
