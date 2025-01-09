package com.ust.app.springsecurity.api;

import com.ust.app.springsecurity.dto.ApiResponseMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @GetMapping
    public ApiResponseMessage sayHello(){
        return new ApiResponseMessage("Hello User");
    }
}
