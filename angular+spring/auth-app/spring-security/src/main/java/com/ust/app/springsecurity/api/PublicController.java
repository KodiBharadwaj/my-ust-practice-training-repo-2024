package com.ust.app.springsecurity.api;

import com.ust.app.springsecurity.dto.ApiResponseMessage;
import com.ust.app.springsecurity.dto.UserCredentials;
import com.ust.app.springsecurity.model.UserModel;
import com.ust.app.springsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin
public class PublicController {

    @GetMapping
    public ApiResponseMessage sayHello(){
        return new ApiResponseMessage("Hello All");
    }

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UserCredentials registerUser(@RequestBody UserModel user){
        UserModel userModel = authService.save(user);
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userModel.getUsername());
        userCredentials.setPassword(userModel.getPassword());
        return userCredentials;
    }
}
