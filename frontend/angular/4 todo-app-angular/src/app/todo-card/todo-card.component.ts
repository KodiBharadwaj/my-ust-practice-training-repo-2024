import { CommonModule } from "@angular/common";
import { Component, Input } from "@angular/core";
import { Todo } from "../model/Todo";
import { TodoApiService } from "../todo-api.service";
import { TodoDataService } from "../todo-data.service";

@Component({
  selector: 'app-todo-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './todo-card.component.html',
  styleUrl: './todo-card.component.css'
})
export class TodoCardComponent {
  @Input('todo') todo?: Todo;

  constructor(
    private todoApiService: TodoApiService, 
    public todoDataService: TodoDataService
  ) {}

  deleteTodo(title:any){
    this.todoApiService.deleteTodo(title).subscribe(
      response => {
        console.log("deleted successfully", response);
      }
    );
  }
}
