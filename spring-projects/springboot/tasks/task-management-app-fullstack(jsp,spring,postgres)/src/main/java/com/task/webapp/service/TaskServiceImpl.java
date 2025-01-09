package com.task.webapp.service;

import com.task.webapp.dto.TaskDto;
import com.task.webapp.exception.RecordNotFoundException;
import com.task.webapp.model.Task;
import com.task.webapp.repository.TaskRepository;
import com.task.webapp.util.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public TaskDto save(TaskDto taskDto) {

        if(taskRepository.existsById(taskDto.id())){
            throw new RuntimeException("Task with ID " + taskDto.id() + " Already Present");
        }

        Task task2 = taskRepository.save(EntityToDto.converToEntity(taskDto));
        return EntityToDto.convertToDto(task2);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public TaskDto getTaskByid(int id) {
        return taskRepository.findById(id).map(i->EntityToDto.convertToDto(i)).orElse(null);
    }

    @Override
    public List<TaskDto> getTaskByStatus(String status) {
        return taskRepository.findByStatus(status).stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public List<TaskDto> getTasksBySortedDates() {
        return taskRepository.getTasksBySortedDates().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public List<TaskDto> getTasksByOverDueDates() {
        return taskRepository.getTasksByOverDueDates(LocalDate.now()).stream().map(i->EntityToDto.convertToDto(i)).toList();
    }


    @Override
    public void deleteTask(int id) {
        if(!taskRepository.existsById(id)){
            throw new RecordNotFoundException("Task with id " + id + " is not found to delete");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto updateTaskById(int id, TaskDto taskDto) {

        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Task with ID "+id+" Not Found");
        }

        Task task1 = EntityToDto.converToEntity(getTaskByid(id));
        if(taskDto.username() != null){
            task1.setUsername(taskDto.username());
        }
        if(taskDto.description() != null){
            task1.setDescription(taskDto.description());
        }
        if(taskDto.date() != null){
            task1.setDate(taskDto.date());
        }
        if(taskDto.status() != null){
            task1.setStatus(taskDto.status());
        }
        return EntityToDto.convertToDto(taskRepository.save(task1));
    }
}
