package com.example.Project.Example1.adminManagement.facade;

import com.example.Project.Example1.Auth_Management.Jwt.JwtUtil;
import com.example.Project.Example1.Auth_Management.UserDetailServise.CustomDetailsService;
import com.example.Project.Example1.adminManagement.dto.*;
import com.example.Project.Example1.adminManagement.entity.Role;
import com.example.Project.Example1.adminManagement.entity.UserAccount;
import com.example.Project.Example1.adminManagement.Mapper.UserMapper;
import com.example.Project.Example1.adminManagement.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtUtil  jwtUtil;
    private final CustomDetailsService userDetailsService;

    public UserFacade(UserService userService, UserMapper userMapper, JwtUtil jwtUtil, CustomDetailsService userDetailsService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    public UserResponse register(UserRegisterRequest req) {
        UserAccount user = userMapper.toEntity(req);
        String roleName = "ROLE_" + req.getRole().toUpperCase();
        Role role = userService.getOrCreateRole(roleName);
        user.setRoles(Set.of(role));
        UserAccount saved = userService.save(user);
        return userMapper.toDto(saved);
    }


    public UserResponse getById(Long id) {
        UserAccount user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return userMapper.toDto(user);
    }
    public LoginResponse login(LoginRequest req) {
        UserAccount user = userService.login(req.getEmailOrMobileNumber(), req.getPassword());
        UserDetails ud = userDetailsService.loadUserByUsername(req.getEmailOrMobileNumber());
        String jwt = jwtUtil.generateToken(ud);

        LoginResponse response = new LoginResponse();
        response.setName(user.getName());
        response.setAccessToken(jwt);
        response.setTokenType("Bearer");
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setMobileNumber(user.getMobileNumber());

        response.setRoleName(user.getRoles().iterator().next().getName());

        return response;
    }
    public void resetPassword(ResetPasswordRequest request) {
        userService.resetPassword(request);
    }
    public void sendOtpForForgotPassword(ForgotPasswordRequest req) {
        userService.sendOtpForPasswordReset(req.getEmail());
    }

    public void createNewPassword(CreateNewPasswordRequest req) {
        userService.verifyOtpAndSetNewPassword(req.getEmail(), req.getOtp(), req.getNewPassword(), req.getConfirmPassword());
    }
}
