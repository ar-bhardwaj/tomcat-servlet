package com.example.user_register;

public class User {
    public String name;
    public String password;
    public String email;

    User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", email=" + email + '}';
    }
}
