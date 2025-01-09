import { Component } from '@angular/core';
import { AddTodosReactiveComponent } from '../add-todos-reactive/add-todos-reactive.component';
import { AddTodosComponent } from '../add-todos/add-todos.component';
import { ViewTodosComponent } from '../view-todos/view-todos.component';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [AddTodosComponent, ViewTodosComponent, AddTodosReactiveComponent],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {

}
