package com.example.Project.Example1.adminManagement.dto;

import java.util.List;

public class LoginRequest {
    private String emailOrMobileNumber;
    private String password;


    public LoginRequest() {}

    public String getEmailOrMobileNumber() {
        return emailOrMobileNumber;
    }

    public void setEmailOrMobileNumber(String emailOrMobileNumber) {
        this.emailOrMobileNumber = emailOrMobileNumber;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
