import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from './components/page-title/page-title.component';
import { CircularLoadingComponent } from './components/circular-loading/circular-loading.component';
import { FilledButtonComponent } from './components/filled-button/filled-button.component';
import { TextButtonComponent } from './components/text-button/text-button.component';
import { CardComponent } from './components/card/card.component';
import { InputCardComponent } from './components/input-card/input-card.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PageTitleComponent,
    CircularLoadingComponent,
    FilledButtonComponent,
    TextButtonComponent,
    CardComponent,
    InputCardComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    PageTitleComponent,
    CircularLoadingComponent,
    FilledButtonComponent,
    TextButtonComponent,
    CardComponent,
    InputCardComponent
  ]
})
export class SharedModule { }
