import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from './components/page-title/page-title.component';
import { CircularLoadingComponent } from './components/circular-loading/circular-loading.component';


@NgModule({
  declarations: [
    PageTitleComponent,
    CircularLoadingComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PageTitleComponent,
    CircularLoadingComponent
  ]
})
export class SharedModule { }
