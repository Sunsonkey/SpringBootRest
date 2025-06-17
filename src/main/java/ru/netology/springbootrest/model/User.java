package ru.netology.springbootrest.model;

import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Username must not be blank")
    private String user;

    @NotBlank(message = "Password must not be blank")
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}