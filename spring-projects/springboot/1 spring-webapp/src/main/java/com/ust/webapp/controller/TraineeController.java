package com.ust.webapp.controller;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepo;
import com.ust.webapp.repository.TraineeRepoImpl;
import com.ust.webapp.service.TraineeService;
import com.ust.webapp.service.TraineeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @PostMapping("/add-trainee")
    public String addTrainee(Model m, @RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("location") String location){

        TraineeDto trainee = new TraineeDto(id, name, location);

        traineeService.save(trainee);

        List<TraineeDto> list = traineeService.getAllTrainees();

        m.addAttribute("list", list);
        m.addAttribute("trainee", null);

        return "view-trainee.jsp";
    }

//    public String addTrainee(@ModelAttribute("trainee") Trainee trainee){
//        traineeRepo.save(trainee);
//        return "view-trainee.jsp";
//    }


    @GetMapping("/get-trainees")
    public String getAllTrainees(Model m){

        List<TraineeDto> list = traineeService.getAllTrainees();

        m.addAttribute("list", list);
        m.addAttribute("trainee", null);
        return "view-trainee.jsp";
    }

    @GetMapping("/get-trainee-by-id")
    public String gettraineebyId(Model m, @RequestParam("searchid") int id){
        TraineeDto trainee = traineeService.getTraineeById(id);

        m.addAttribute("list", null);
        m.addAttribute("trainee", trainee);

        return "view-trainee.jsp";
    }

    @GetMapping("/delete-trainee")
    public String deleteTrainee(Model m, @RequestParam("id") int id){
        traineeService.deleteTraineeById(id);
        List<TraineeDto> list = traineeService.getAllTrainees();
        m.addAttribute("list", list);
        m.addAttribute("trainee", null);
        return "view-trainee.jsp";
    }


}
