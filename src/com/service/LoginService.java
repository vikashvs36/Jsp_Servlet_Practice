package com.service;

// LoginService is used like a service class.
public class LoginService {

    // Create Constructor
    public LoginService(){}

    // To check username and password are valid or not.
    public boolean login(String username, String password){
        // Check username or password is correct or not.
        if (username.equals("Vikash") && password.equals("Singh")){ return true; }
        else { return false; }
    }

}
