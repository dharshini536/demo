package com.example.Project.Example1.adminManagement.Service.ServiceImpl;

import com.example.Project.Example1.Auth_Management.GlobalException.CommonExceptionHandler;
import com.example.Project.Example1.adminManagement.Service.OtpService;
import com.example.Project.Example1.adminManagement.adapter.UserAdapter;
import com.example.Project.Example1.adminManagement.dto.ResetPasswordRequest;
import com.example.Project.Example1.adminManagement.entity.Role;
import com.example.Project.Example1.adminManagement.entity.UserAccount;
import com.example.Project.Example1.adminManagement.Repository.RoleRepository;
import com.example.Project.Example1.adminManagement.Repository.UserRepository;
import com.example.Project.Example1.adminManagement.Service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserAdapter userAdapter;
    private final OtpService  otpService;

    public UserServiceImpl(UserRepository userRepo,
                           RoleRepository roleRepo,
                           PasswordEncoder passwordEncoder, UserAdapter userAdapter, OtpService otpService) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.userAdapter = userAdapter;
        this.otpService = otpService;
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserAccount save(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role getOrCreateRole(String roleName) {
        return roleRepo.findByName(roleName)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleName);
                    return roleRepo.save(r);

                });
    }
    @Override
    public UserAccount login(String emailOrMobile, String password) {
        Optional<UserAccount> optionalUser;
        if (emailOrMobile.contains("@")) {
            optionalUser = userAdapter.findByEmail(emailOrMobile);
        } else {
            optionalUser = userAdapter.findByMobileNumber(emailOrMobile);
        }
        UserAccount user = optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email/mobile: " + emailOrMobile));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CommonExceptionHandler.InvalidCredentialsException("Invalid password");
        }
        return user;
    }
    @Override
    public void resetPassword(ResetPasswordRequest request) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("New password and confirm password do not match");
        }
        if(!request.getNewPassword().equals(request.getOldPassword())) {
            Optional<UserAccount> optionalUser = request.getEmailOrMobile().contains("@")
                    ? userAdapter.findByEmail(request.getEmailOrMobile())
                    : userAdapter.findByMobileNumber(request.getEmailOrMobile());
            UserAccount user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
            if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                throw new RuntimeException("Old password is incorrect");
            }
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userRepo.save(user);
        }
        else{throw new RuntimeException("Old password and New password are same");}
    }


    @Override
    public void sendOtpForPasswordReset(String email) {
        Optional<UserAccount> optionalUser = userAdapter.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }
        otpService.generateAndSendOtp(email);
    }

    @Override
    public void verifyOtpAndSetNewPassword(String email, String otp, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw new CommonExceptionHandler.InvalidOtpException("Passwords do not match");
        }

        if (!otpService.validateOtp(email, otp)) {
            throw new CommonExceptionHandler.InvalidOtpException("invalid User or OTP");
        }

        UserAccount user = userAdapter.findByEmail(email)
                .orElseThrow(() -> new CommonExceptionHandler.InvalidOtpException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
        otpService.clearOtp(email);
    }

}
