import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Task } from '../model/Taks';

@Component({
  selector: 'app-task-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-card.component.html',
  styleUrl: './task-card.component.css'
})
export class TaskCardComponent {

  @Input('task')
  task?:Task;

 

}

