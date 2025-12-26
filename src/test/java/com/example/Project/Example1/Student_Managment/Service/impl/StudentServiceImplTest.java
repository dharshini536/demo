package com.example.Project.Example1.Student_Managment.Service.impl;

import com.example.Project.Example1.Student_Managment.Adapter.StudentAdapter;
import com.example.Project.Example1.Student_Managment.Entity.SecondaryDetails;
import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import com.example.Project.Example1.Student_Managment.Repositoty.SecondaryDetailsRepository;
import com.example.Project.Example1.Student_Managment.mapper.StudentEntityMapper;
import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import com.example.Project.Example1.Auth_Management.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentAdapter studentAdapter;

    @Mock
    private StudentEntityMapper studentEntityMapper;

    @Mock
    private SecondaryDetailsRepository secondaryDetailsRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private StudentServiceImpl studentService;


    @Test
    void saveStudent_whenNoSecondaryDetailsAndEmail_present_shouldEncodePasswordAndSendEmail() {
        StudentRegisterModel inputModel = new StudentRegisterModel();
        inputModel.setFirstName("John");
        inputModel.setLastName("Doe");
        inputModel.setEmail("john.doe@example.com");

        StudentEntity entityFromMapper = new StudentEntity();
        entityFromMapper.setFirstName("John");
        entityFromMapper.setLastName("Doe");
        entityFromMapper.setEmail("john.doe@example.com");
        entityFromMapper.setSecondaryDetails(null);

        when(studentEntityMapper.toEntity(inputModel)).thenReturn(entityFromMapper);

        String rawPassword = "generatedPwd";
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPwd");

        StudentEntity savedEntity = new StudentEntity();
        savedEntity.setFirstName("John");
        savedEntity.setLastName("Doe");
        savedEntity.setEmail("john.doe@example.com");
        when(studentAdapter.SaveStudent(entityFromMapper)).thenReturn(savedEntity);
        when(studentEntityMapper.toModel(savedEntity)).thenReturn(inputModel);

        StudentRegisterModel resultModel = studentService.saveStudent(inputModel);

        assertThat(resultModel).isNotNull();
        assertThat(resultModel.getEmail()).isEqualTo("john.doe@example.com");
        verify(passwordEncoder).encode(anyString());
        verify(studentAdapter).SaveStudent(entityFromMapper);
        verify(emailService).sendStudentRegistrationEmail(eq("john.doe@example.com"), anyString(), anyString());
    }

    @Test
    void saveStudent_whenSecondaryDetailsPresent_shouldSaveSecondaryDetails() {
        StudentRegisterModel inputModel = new StudentRegisterModel();
        inputModel.setFirstName("Alice");
        inputModel.setLastName("Smith");
        inputModel.setEmail("alice.smith@example.com");

        StudentEntity entityFromMapper = new StudentEntity();
        entityFromMapper.setFirstName("Alice");
        entityFromMapper.setLastName("Smith");
        entityFromMapper.setEmail("alice.smith@example.com");
        SecondaryDetails sec = new SecondaryDetails();
        entityFromMapper.setSecondaryDetails(sec);

        when(studentEntityMapper.toEntity(inputModel)).thenReturn(entityFromMapper);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPwd2");

        when(secondaryDetailsRepository.save(sec)).thenReturn(sec);
        StudentEntity savedEntity = new StudentEntity();
        savedEntity.setFirstName("Alice");
        savedEntity.setLastName("Smith");
        savedEntity.setEmail("alice.smith@example.com");
        savedEntity.setSecondaryDetails(sec);

        when(studentAdapter.SaveStudent(entityFromMapper)).thenReturn(savedEntity);
        when(studentEntityMapper.toModel(savedEntity)).thenReturn(inputModel);

        StudentRegisterModel resultModel = studentService.saveStudent(inputModel);

        assertThat(resultModel).isNotNull();
        verify(secondaryDetailsRepository).save(sec);
        verify(studentAdapter).SaveStudent(entityFromMapper);
        verify(emailService).sendStudentRegistrationEmail(eq("alice.smith@example.com"), anyString(), anyString());
    }
}
