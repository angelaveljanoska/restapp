package com.example.webservices.controller;

import com.example.webservices.model.User;
import com.example.webservices.model.UserDto;
import com.example.webservices.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userInput) {
        return ResponseEntity.ok(userService.login(userInput.getUsername(), userInput.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) throws Exception {
        userService.register(userDto.getUsername(), userDto.getFirstPassword(), userDto.getSecondPassword());
        return ResponseEntity.ok("Successful registration!");
    }

    @DeleteMapping
    public ResponseEntity<String> unregister(@RequestBody UserDto userDto) throws Exception {
        userService.unregister(userDto.getUsername(), userDto.getFirstPassword(), userDto.getSecondPassword());
        return ResponseEntity.ok("Successful removal!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, WebRequest req) {
        return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

}
