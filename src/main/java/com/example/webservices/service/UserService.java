package com.example.webservices.service;

import com.example.webservices.model.User;
import com.example.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void register(String username, String firstPassword, String secondPassword) throws Exception;

    public String login (String username, String password);

    public void unregister(String username, String firstPassword, String secondPassword) throws Exception;
}
