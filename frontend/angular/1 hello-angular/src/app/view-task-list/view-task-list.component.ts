import { Component, Input } from '@angular/core';

import { TaskCardComponent } from "../task-card/task-card.component";
import { CommonModule } from '@angular/common';
import { Task } from '../model/Taks';

@Component({
  selector: 'app-view-task-list',
  standalone: true,
  imports: [TaskCardComponent, CommonModule],
  templateUrl: './view-task-list.component.html',
  styleUrl: './view-task-list.component.css'
})
export class ViewTaskListComponent {

  @Input('taskList')
  taskList?:Array<Task> = [];
  
}
