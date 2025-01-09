package com.ust.todoapp.repository;

import com.ust.todoapp.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    public Task findByTitle(String title);

    @Modifying
    @Transactional
    @Query("delete from Task t where t.title = :title")
    public void deleteByTitle(String title);
}
