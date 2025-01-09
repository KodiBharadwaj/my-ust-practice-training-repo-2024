package com.example.demo.controller;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.util.EntityToDto.converToEntity;
import static com.example.demo.util.EntityToDto.convertToDto;


@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin("http://localhost:5000")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task saveTask(@RequestBody Task task){
        TaskDto taskDto = convertToDto(task);
        TaskDto obj = taskService.save(taskDto);
        return converToEntity(obj);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto getTraineeById(@PathVariable("id") int id){
        return taskService.getTaskByid(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable("id") int id){
        taskService.deleteTask(id);
    }

    @GetMapping("/by-dates")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getTasksBySortedDates(){
        return taskService.getTaskBySortedDates();
    }

    @GetMapping("/overdue-dates")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getTaskByOverdueTasks(){
        return taskService.getTaskByOverdueTasks();
    }

    @GetMapping("/status")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getTasksByStatus(@RequestParam("name") String status){
        return taskService.getTasksByStatus(status);
    }

}
