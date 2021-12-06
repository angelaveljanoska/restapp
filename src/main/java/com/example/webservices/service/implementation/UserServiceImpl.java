package com.example.webservices.service.implementation;

import com.example.webservices.model.User;
import com.example.webservices.repository.UserRepository;
import com.example.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void register(String username, String firstPassword, String secondPassword) throws Exception {
        if(firstPassword.equals(secondPassword)) {
            User user = new User(username, firstPassword);
            userRepository.save(user);
        }
        else {
            throw new Exception("Passwords don't match!");
        }
    }

    @Override
    public String login(String username, String password) {
        User user = userRepository.findUserByUsername(username).get();

        if(user.getPassword().equals(password)) {
            return "User is logged in!";
        }
        else {
            return "Incorrect username or password!";
        }
    }

    @Override
    public void unregister(String username, String firstPassword, String secondPassword) throws Exception {
        if(firstPassword.equals(secondPassword)) {
            User user = new User(username, firstPassword);
            userRepository.deleteUserByUsername(username);
        }
        else {
            throw new Exception("Passwords don't match!");
        }
    }


}
