package com.example.demo.repository;

import com.example.demo.model.Task;


import java.util.List;

public interface TaskRepository {

   public Task save(Task task);

   public List<Task> findAll();

   public Task findById(int id);

   void deleteTask(int id);

   public List<Task> getTaskBySortedDates();

   public List<Task> getTaskByOverdueTasks();

   public List<Task> getTasksByStatus(String status);
}
