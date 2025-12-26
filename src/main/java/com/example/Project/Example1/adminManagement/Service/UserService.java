package com.example.Project.Example1.adminManagement.Service;

import com.example.Project.Example1.adminManagement.dto.ResetPasswordRequest;
import com.example.Project.Example1.adminManagement.entity.Role;
import com.example.Project.Example1.adminManagement.entity.UserAccount;

import java.util.Optional;

public interface UserService {
    UserAccount login(String emailOrMobile, String password);
    UserAccount save(UserAccount user);
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findById(Long id);
    Role getOrCreateRole(String roleName);
    void resetPassword(ResetPasswordRequest request);
    void sendOtpForPasswordReset(String email);
    void verifyOtpAndSetNewPassword(String email, String otp, String newPassword, String confirmPassword);
}
