package com.task.webapp.controller;

import com.task.webapp.dto.TaskDto;
import com.task.webapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getfrontpage(){
        return "add-task.jsp";
    }


    @PostMapping("/add-task")
    public String addTask(Model m, @RequestParam("id") int id,
                          @RequestParam("username") String username,
                          @RequestParam("description") String description,
                          @RequestParam("date") LocalDate date,
                          @RequestParam("status") String status){

        TaskDto taskDto = new TaskDto(id, username, description, date, status);
        taskService.save(taskDto);

        List<TaskDto> list = taskService.getAllTasks();

        m.addAttribute("list", list);
        m.addAttribute("task", null);
        return "view-task.jsp";
    }

    @GetMapping("/get-all-tasks")
    public String getTasks(Model m){
        List<TaskDto> list = taskService.getAllTasks();

        m.addAttribute("list", list);
        m.addAttribute("task", null);
        return "view-task.jsp";
    }


    @GetMapping("/get-task-by-id")
    public String getTaskById(Model m, @RequestParam("searchid") int id){
        TaskDto task = taskService.getTraineeByid(id);
        m.addAttribute("task", task);
        m.addAttribute("list", null);
        return "view-task.jsp";
    }


    @GetMapping("/delete-task")
    public String deleteTask(Model m, @RequestParam("id") int id){
        taskService.deleteTask(id);

        List<TaskDto> list = taskService.getAllTasks();
        m.addAttribute("list", list);
        m.addAttribute("task", null);
        return "view-task.jsp";
    }

}
