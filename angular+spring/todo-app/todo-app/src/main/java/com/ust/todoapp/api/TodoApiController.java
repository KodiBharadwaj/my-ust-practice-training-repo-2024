package com.ust.todoapp.api;

import com.ust.todoapp.exception.RecordNotFoundException;
import com.ust.todoapp.model.Task;
import com.ust.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TodoApiController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        Task existingTask = taskRepository.findByTitle(task.getTitle());
        if (existingTask != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Task already exists!");
        }

        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping
    public List<Task> fetchAllTasks(){
        return taskRepository.findAll();
    }

    @DeleteMapping("/{title}")
    public void deleteTodo(@PathVariable("title") String title){
        taskRepository.deleteByTitle(title);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id){
        return taskRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("No Task found with Id "+ id));
    }
}
