package com.example.demo.repository;

import com.example.demo.model.Task;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    List<Task> list;

    @PostConstruct
    void inti(){
        list = new ArrayList<>();
        Task task = new Task(1, "Cricket", "Want to play cricket", LocalDate.parse("2024-10-10"), "Completed");
        Task task2 = new Task(2, "Chess", "Want to play cricket", LocalDate.parse("2024-09-10"), "Not-Completed");

        list.add(task);
        list.add(task2);
    }
    @Override
    public Task save(Task task) {
        list.add(task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return list;
    }

    @Override
    public Task findById(int id) {
        return list.stream().filter(i->i.getId() == id).findFirst().get();
    }

    @Override
    public void deleteTask(int id) {
        list.removeIf(i->i.getId() == id);
    }

    @Override
    public List<Task> getTaskBySortedDates() {
        return list.stream().sorted((a,b)->a.getDate().compareTo(b.getDate())).toList();
    }

    @Override
    public List<Task> getTaskByOverdueTasks() {
        return list.stream().filter(i->i.getDate().compareTo(LocalDate.now()) < 0).sorted((a,b)->a.getDate().compareTo(b.getDate())).toList();
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return list.stream().filter(i->i.getStatus().equals(status)).toList();
    }
}
