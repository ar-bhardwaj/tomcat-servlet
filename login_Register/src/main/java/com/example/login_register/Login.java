package com.example.login_register;

public class Login {
    String username;
    String password;

    Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + '}';
    }
}
