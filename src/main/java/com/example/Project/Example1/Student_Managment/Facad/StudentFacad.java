package com.example.Project.Example1.Student_Managment.Facad;

import com.example.Project.Example1.Student_Managment.Service.StudentService;
import com.example.Project.Example1.Student_Managment.dto.StudentRegistrationDto;
import com.example.Project.Example1.Student_Managment.dto.StudentResetPasswordDto;
import com.example.Project.Example1.Student_Managment.mapper.StudentDtoMapper;
import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import org.springframework.stereotype.Component;

@Component
public class StudentFacad {
    private final StudentDtoMapper studentDtoMapper;
    private final StudentService studentService;

    public StudentFacad(StudentDtoMapper studentDtoMapper, StudentService studentService) {
        this.studentDtoMapper = studentDtoMapper;
        this.studentService = studentService;
    }

    public StudentRegistrationDto saveStudent(StudentRegistrationDto dto) {
        StudentRegisterModel model = studentDtoMapper.toModel(dto);
        StudentRegisterModel savedModel = studentService.saveStudent(model);
        return studentDtoMapper.toDto(savedModel);
    }
    public void resetPassword(StudentResetPasswordDto dto) {
        com.example.Project.Example1.Student_Managment.model.StudentResetPasswordModel model =
                studentDtoMapper.toModel(dto);
        studentService.resetPassword(model);
    }
}
