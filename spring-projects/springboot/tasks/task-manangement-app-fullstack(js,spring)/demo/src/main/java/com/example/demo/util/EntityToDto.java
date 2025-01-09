package com.example.demo.util;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;


public class EntityToDto {

    public static Task converToEntity(TaskDto taskDto){
        Task task = new Task(taskDto.id(), taskDto.username(), taskDto.description(), taskDto.date(), taskDto.status());
        return task;
    }

    public static TaskDto convertToDto(Task task){
        TaskDto taskDto = new TaskDto(task.getId(), task.getUsername(), task.getDescription(), task.getDate(), task.getStatus());
        return taskDto;
    }
}
