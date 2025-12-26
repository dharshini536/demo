package com.example.Project.Example1.adminManagement.controller;


import com.example.Project.Example1.Auth_Management.Jwt.JwtUtil;
import com.example.Project.Example1.Auth_Management.UserDetailServise.CustomDetailsService;
import com.example.Project.Example1.Auth_Management.apiResponse.ApiResponse;
import com.example.Project.Example1.adminManagement.dto.*;
import com.example.Project.Example1.adminManagement.facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final CustomDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserFacade userFacade;

    public AuthController(AuthenticationManager authManager,
                          CustomDetailsService userDetailsService,
                          JwtUtil jwtUtil,
                          UserFacade userFacade) {
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegisterRequest req) {
        return userFacade.register(req);
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest loginReq) {
        LoginResponse response=userFacade.login(loginReq);
        return ResponseEntity.ok(new ApiResponse<>(200, "Login Success", response));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<ApiResponse<String>> resetPassword(@RequestBody ResetPasswordRequest req) {
        userFacade.resetPassword(req);
        return ResponseEntity.ok(new ApiResponse<>(200, "Password reset successful", null));
    }
    @PostMapping("/forgot-password/send-otp")
    public ResponseEntity<ApiResponse<String>> sendOtp(@RequestBody ForgotPasswordRequest req) {
        userFacade.sendOtpForForgotPassword(req);
        return ResponseEntity.ok(new ApiResponse<>(200, "OTP sent to email successfully", null));
    }

    @PostMapping("/forgot-password/verify")
    public ResponseEntity<ApiResponse<String>> verifyOtpAndSetPassword(@RequestBody CreateNewPasswordRequest req) {
        userFacade.createNewPassword(req);
        return ResponseEntity.ok(new ApiResponse<>(200, "Password updated successfully", null));
    }

}
