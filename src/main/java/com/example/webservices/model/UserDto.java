package com.example.webservices.model;

public class UserDto {
    private String username;
    private String firstPassword;
    private String secondPassword;

    public UserDto(String username, String firstPassword, String secondPassword) {
        this.username = username;
        this.firstPassword = firstPassword;
        this.secondPassword = secondPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }
}
