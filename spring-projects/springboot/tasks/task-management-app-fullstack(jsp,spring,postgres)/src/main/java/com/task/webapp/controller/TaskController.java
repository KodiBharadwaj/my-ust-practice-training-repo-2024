package com.task.webapp.controller;

import com.task.webapp.dto.TaskDto;
import com.task.webapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        if(taskService.getTaskByid(id) != null){
            List<TaskDto> list = taskService.getAllTasks();
            m.addAttribute("list", list);
            m.addAttribute("task", null);
            m.addAttribute("taskError", taskService.getTaskByid(id));
            return "view-task.jsp";
        }
        TaskDto taskDto = new TaskDto(id, username, description, date, status);
        taskService.save(taskDto);

        List<TaskDto> list = taskService.getAllTasks();

        m.addAttribute("list", list);
        m.addAttribute("task", null);
        m.addAttribute("taskError", null);
        return "view-task.jsp";

    }

    @GetMapping("/get-all-tasks")
    public String getTasks(Model m){
        List<TaskDto> list = taskService.getAllTasks();

        m.addAttribute("list", list);
        m.addAttribute("task", null);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }


    @GetMapping("/get-task-by-id")
    public String getTaskById(Model m, @RequestParam("searchid") int id){
        TaskDto task = taskService.getTaskByid(id);
        m.addAttribute("task", task);
        m.addAttribute("list", null);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }

    @GetMapping("/by-dates")
    public String getTaskBySortedDates(Model m){
        List<TaskDto> list = taskService.getTasksBySortedDates();
        m.addAttribute("task", null);
        m.addAttribute("list", list);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }

    @GetMapping("/overdue-dates")
    public String getOverDueTasks(Model m){
        List<TaskDto> list = taskService.getTasksByOverDueDates();
        m.addAttribute("task", null);
        m.addAttribute("list", list);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }

    @GetMapping("/status")
    public String getTaskByStatus(Model m, @RequestParam("name") String status){
        List<TaskDto> list = taskService.getTaskByStatus(status);
        m.addAttribute("task", null);
        m.addAttribute("list", list);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }


    @GetMapping("/delete-task")
    public String deleteTask(Model m, @RequestParam("id") int id){
        taskService.deleteTask(id);

        List<TaskDto> list = taskService.getAllTasks();
        m.addAttribute("list", list);
        m.addAttribute("task", null);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }

    @PostMapping("/update-task")
    public String updateTask(Model m, @RequestParam("id") int id,
                             @RequestParam("username") String username,
                             @RequestParam("description") String description,
                             @RequestParam("date") LocalDate date,
                             @RequestParam("status") String status){

        TaskDto taskDto = new TaskDto(id, username, description, date, status);

        taskService.updateTaskById(id, taskDto);
        List<TaskDto> list = taskService.getAllTasks();

        m.addAttribute("list", list);
        m.addAttribute("task", null);
        m.addAttribute("taskError", null);
        return "view-task.jsp";
    }

}
