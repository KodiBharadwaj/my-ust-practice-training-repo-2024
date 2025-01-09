package com.task.webapp.repository;

import com.task.webapp.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    List<Task> list;

    @PostConstruct
    void init(){
        list = new ArrayList<>();
        Task task = new Task(1, "Cricket", "Want to play cricket", LocalDate.parse("2024-10-07"), "Not-Completed");
        list.add(task);
    }

    @Override
    public Task save(Task task) {
        list.add(task);
        System.out.println(task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return list;
    }

    public Optional<Task> getTraineeByid(int id){
        return list.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public void deleteTask(int id) {
        list.removeIf(i->i.getId() ==  id);
    }
}
