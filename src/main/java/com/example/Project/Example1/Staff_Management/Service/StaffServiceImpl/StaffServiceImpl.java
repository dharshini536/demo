package com.example.Project.Example1.Staff_Management.Service.StaffServiceImpl;

import com.example.Project.Example1.Auth_Management.Service.EmailService;
import com.example.Project.Example1.Staff_Management.Adapter.StaffAdapter;
import com.example.Project.Example1.Staff_Management.Service.StaffSevice;
import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import com.example.Project.Example1.Staff_Management.mapper.StaffEntityMapper;
import com.example.Project.Example1.Staff_Management.model.StaffRegisterModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffSevice {
    private final StaffAdapter staffAdapter;
    private final StaffEntityMapper staffEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public StaffServiceImpl(StaffAdapter staffAdapter, StaffEntityMapper staffEntityMapper, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.staffAdapter = staffAdapter;
        this.staffEntityMapper = staffEntityMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }


    public StaffRegisterModel saveStaff(StaffRegisterModel staffRegisterModel) {
        StaffEntity staffEntity = staffEntityMapper.toEntity(staffRegisterModel);
        String rawPassword = com.example.Project.Example1.Auth_Management.Util.PasswordGenerator.generateDefaultPassword(10);
        staffEntity.setPassword(passwordEncoder.encode(rawPassword));
        StaffEntity staff = staffAdapter.saveStaff(staffEntity);
        try {
            if (staff.getEmail() != null) {
                String fullName = (staff.getFirstName() != null ? staff.getFirstName() : "") + " " +
                        (staff.getLastName() != null ? staff.getLastName() : "");
                emailService.sendStudentRegistrationEmail(staff.getEmail(), fullName.trim(), rawPassword);
            }
        } catch (Exception e) {
            System.err.println("Email sending failed: " + e.getMessage());
        }
        return staffEntityMapper.toModel(staff);
    }
}
