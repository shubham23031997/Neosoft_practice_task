import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ContainerComponent } from './container/container.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ContainerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-app';
  count: number = 0;
  items: string[] = ['Apple', 'Banana', 'Orange'];
  increaseCount() {
    this.count++;
  }
  isDisabled: boolean = true;
  isLoggedIn: boolean = true;
}