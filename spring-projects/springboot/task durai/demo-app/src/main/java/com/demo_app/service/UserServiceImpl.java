package com.demo_app.service;

import com.demo_app.Model.User;
import com.demo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public User save(User user) {

        String password = user.getPassword();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        return userRepository.save(user);

        // check for the password matching.
        // boolean isPasswordMatch = passwordEncoder.matches(enteredPassword, passwordInTheDatabase);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
