package com.example.Project.Example1.adminManagement.Service;

public interface OtpService {
    void generateAndSendOtp(String email);
    boolean validateOtp(String email, String otp);
    void clearOtp(String email);
}
