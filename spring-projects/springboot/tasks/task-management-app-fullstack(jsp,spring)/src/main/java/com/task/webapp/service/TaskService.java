package com.task.webapp.service;

import com.task.webapp.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public TaskDto save(TaskDto taskDto);

    public List<TaskDto> getAllTasks();

    public TaskDto getTraineeByid(int id);

    public void deleteTask(int id);
}
