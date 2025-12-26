package com.example.Project.Example1.Student_Managment.Service.impl;

import com.example.Project.Example1.Auth_Management.Service.EmailService;
import com.example.Project.Example1.Auth_Management.Util.PasswordGenerator;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsAdapter.CategoryLevelAdapter;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository.LevelHelperRepository;
import com.example.Project.Example1.Student_Managment.Adapter.StudentAdapter;
import com.example.Project.Example1.Student_Managment.Entity.SecondaryDetails;
import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import com.example.Project.Example1.Student_Managment.Repositoty.SecondaryDetailsRepository;
import com.example.Project.Example1.Student_Managment.Service.StudentService;
import com.example.Project.Example1.Student_Managment.mapper.StudentEntityMapper;
import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import com.example.Project.Example1.Student_Managment.model.StudentResetPasswordModel;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentAdapter studentAdapter;
    private final StudentEntityMapper studentEntityMapper;
    private final SecondaryDetailsRepository secondaryDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final CategoryLevelAdapter categoryLevelAdapter;
    private final LevelHelperRepository levelHelperRepository;

    public StudentServiceImpl(StudentAdapter studentAdapter, StudentEntityMapper studentEntityMapper, SecondaryDetailsRepository secondaryDetailsRepository, PasswordEncoder passwordEncoder, EmailService emailService, CategoryLevelAdapter categoryLevelAdapter, LevelHelperRepository levelHelperRepository) {
        this.studentAdapter = studentAdapter;
        this.studentEntityMapper = studentEntityMapper;
        this.secondaryDetailsRepository = secondaryDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.categoryLevelAdapter = categoryLevelAdapter;
        this.levelHelperRepository = levelHelperRepository;
    }


    @Override
    @Transactional
    public StudentRegisterModel saveStudent(StudentRegisterModel model) {
        StudentEntity entity = studentEntityMapper.toEntity(model);
        Level level = categoryLevelAdapter.getLevelById(model.getSkillLevel());
        if (level != null) {
            entity.setSkillLevel(level);
        }
        LevelHelper fee = levelHelperRepository.findById(model.getSkillLevel()).orElseThrow(()->new RuntimeException("Level helper id not found"));
        entity.setFeeDetails(fee);
        String rawPassword = PasswordGenerator.generateDefaultPassword(10);
        entity.setPassword(passwordEncoder.encode(rawPassword));
        StudentEntity savedEntity = studentAdapter.SaveStudent(entity);
        try {
            if (savedEntity.getEmail() != null) {
                String fullName = (savedEntity.getFirstName() + " " + savedEntity.getLastName()).trim();
                emailService.sendStudentRegistrationEmail(savedEntity.getEmail(), fullName, rawPassword);
            }
        } catch (Exception e) {
            System.err.println("Email sending failed: " + e.getMessage());
        }
        return studentEntityMapper.toModel(savedEntity);
    }
    @Override
    @Transactional
    public void resetPassword(StudentResetPasswordModel resetModel) {
        // 1. Get student by email
        StudentEntity student = studentAdapter.findByEmail(resetModel.getEmail())
                .orElseThrow(() -> new NoSuchElementException("Student not found with email: " + resetModel.getEmail()));

        // 2. Verify current password
        boolean matches = passwordEncoder.matches(resetModel.getCurrentPassword(), student.getPassword());
        if (!matches) {
            throw new IllegalArgumentException("Current password is incorrect");
        }

        // 3. Encode new password
        String encodedNewPassword = passwordEncoder.encode(resetModel.getNewPassword());

        // 4. Update using repository query
        int updated = studentAdapter.resetPassword(resetModel.getEmail(), encodedNewPassword);
        if (updated == 0) {
            throw new IllegalStateException("Password update failed");
        }
    }

}
