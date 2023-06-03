import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SideNavComponent } from './components/side-nav/side-nav.component';
import { LayoutComponent } from './layout/layout.component';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
  declarations: [
    LayoutComponent,
    SideNavComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
  ],
  exports:[
    LayoutComponent
  ]
})
export class CoreModule { }
