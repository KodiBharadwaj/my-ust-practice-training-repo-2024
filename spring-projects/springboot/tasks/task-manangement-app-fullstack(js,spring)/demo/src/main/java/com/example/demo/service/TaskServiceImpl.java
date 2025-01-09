package com.example.demo.service;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.util.EntityToDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public TaskDto save(TaskDto taskDto) {


        Task task2 = EntityToDto.converToEntity(taskDto);
        taskRepository.save(task2);
        return EntityToDto.convertToDto(task2);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public TaskDto getTaskByid(int id) {
        Task task =  taskRepository.findById(id);
        return EntityToDto.convertToDto(task);
    }


    @Override
    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

    @Override
    public List<TaskDto> getTaskBySortedDates() {
        return taskRepository.getTaskBySortedDates().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public List<TaskDto> getTaskByOverdueTasks() {
        return taskRepository.getTaskByOverdueTasks().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public List<TaskDto> getTasksByStatus(String status) {
        return taskRepository.getTasksByStatus(status).stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

}
