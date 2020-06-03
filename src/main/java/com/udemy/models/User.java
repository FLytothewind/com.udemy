package com.udemy.models;

public class User {
    private  String name;
    private  String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    private final String EMAIL_FOR_REGISTER = System.currentTimeMillis() + "@yopmail.com";

    public String getEmailForRegister() {
        return EMAIL_FOR_REGISTER;
    }
}
