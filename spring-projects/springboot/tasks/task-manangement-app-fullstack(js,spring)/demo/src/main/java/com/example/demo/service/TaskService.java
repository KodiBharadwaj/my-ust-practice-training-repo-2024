package com.example.demo.service;

import com.example.demo.dto.TaskDto;


import java.util.List;

public interface TaskService {

    public TaskDto save(TaskDto taskDto);

    public List<TaskDto> getAllTasks();

    public TaskDto getTaskByid(int id);


    public void deleteTask(int id);

    public List<TaskDto> getTaskBySortedDates();

    public List<TaskDto> getTaskByOverdueTasks();

    public List<TaskDto> getTasksByStatus(String status);

}
