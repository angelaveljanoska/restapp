package com.example.webservices.controller;

import com.example.webservices.model.User;
import com.example.webservices.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password) {
        return ResponseEntity.ok(userService.login(username, password));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(String username, String firstPassword, String secondPassword) throws Exception {
        userService.register(username, firstPassword, secondPassword);
        return ResponseEntity.ok("Successfull registration!");
    }

    @DeleteMapping("unregister")
    public ResponseEntity<String> unregister(String username, String firstPassword, String secondPassword) throws Exception {
        userService.unregister(username, firstPassword, secondPassword);
        return ResponseEntity.ok("Successfull removal!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, WebRequest req) {
        return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

}
