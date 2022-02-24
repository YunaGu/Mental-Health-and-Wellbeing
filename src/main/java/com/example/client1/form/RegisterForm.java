package com.example.client1.form;

//basic java class with getters for register form
public class RegisterForm {
    private String username;
    private String password;

    public RegisterForm(String username, String password) {
        this.username = username;
        this.password = password;

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
