package com.ust.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class AppController {

    @GetMapping("/hello")
//    public String sayHello(Model m, @RequestParam("username") String name){
//        System.out.println(name);
//        String time = LocalTime.now().toString();
//        m.addAttribute("time", time);
//        m.addAttribute("username", name);
//
//        return "hello.jsp";
//    }

    public ModelAndView sayHello(@RequestParam("username") String name){
        System.out.println(name);
        String time = LocalTime.now().toString();
        ModelAndView m = new ModelAndView("hello.jsp");
        m.addObject("time", time);
        m.addObject("username", name);

        return m;
    }
}
