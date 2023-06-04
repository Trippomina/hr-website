// input-card.component.ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-input-card',
  templateUrl: 'input-card.component.html',
  styleUrls: ['input-card.component.css'],
})
export class InputCardComponent {
  @Input() validationType: string = "text";
  @Input() error: string = "";
  value: string = "";

  onFocus() {
    this.error = '';
  }

  onBlur() {
    if (this.validationType === 'text' && !this.value.trim()) {
      this.error = 'Text cannot be empty';
    } else if (this.validationType === 'email') {
      if (!this.value.trim()) {
        this.error = 'Email cannot be empty';
      }
      if (!this.isValidEmail(this.value)) { this.error = 'Invalid email format'; }
    }
  }

  isValidEmail(email: string): boolean {
    // Email validation logic here
    // Return true if email is valid, false otherwise
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }
}
