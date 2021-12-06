package com.example.webservices.controller;

import com.example.webservices.model.User;
import com.example.webservices.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public void register(String username, String firstPassword, String secondPassword) throws Exception {
        userService.register(username, firstPassword, secondPassword);
    }

    @DeleteMapping("unregister")
    public void unregister(String username, String firstPassword, String secondPassword) throws Exception {
        userService.unregister(username, firstPassword, secondPassword);
    }
}
