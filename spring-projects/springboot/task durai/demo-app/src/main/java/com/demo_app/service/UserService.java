package com.demo_app.service;

import com.demo_app.Model.User;

import java.util.List;

public interface UserService {
    public User save(User user);

    public List<User> getUsers();
}
