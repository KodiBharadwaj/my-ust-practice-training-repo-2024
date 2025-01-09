package com.task.webapp.repository;

import com.task.webapp.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    public Task save(Task task);

    public List<Task> getAllTasks();

    public Optional<Task> getTraineeByid(int id);

    public void deleteTask(int id);
}
