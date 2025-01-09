package com.task.webapp.service;

import com.task.webapp.dto.TaskDto;
import com.task.webapp.model.Task;
import com.task.webapp.repository.TaskRepository;
import com.task.webapp.util.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task1 = EntityToDto.converToEntity(taskDto);
        Task task2 = taskRepository.save(task1);
        return EntityToDto.convertToDto(task2);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.getAllTasks().stream().map(i->EntityToDto.convertToDto(i)).toList();
    }

    @Override
    public TaskDto getTraineeByid(int id) {
        return taskRepository.getTraineeByid(id).map(i->EntityToDto.convertToDto(i)).orElse(null);
    }


    @Override
    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }
}
