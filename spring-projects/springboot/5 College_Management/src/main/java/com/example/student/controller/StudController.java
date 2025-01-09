package com.example.student.controller;

import com.example.student.model.College;
import com.example.student.model.Student;
import com.example.student.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class StudController {

    @Autowired
    private CollegeService colServ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public College createCollege(@RequestBody College clg){
      return colServ.createCollege(clg);
    }

    @PostMapping("{id}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@PathVariable long id,@RequestBody Student stud){
        return colServ.createStudent(id,stud);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<College> getAllCollege(){
        return  colServ.getALLColleges();
    }



}
