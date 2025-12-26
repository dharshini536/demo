package com.example.Project.Example1.Student_Managment.mapper;

import com.example.Project.Example1.Student_Managment.dto.StudentRegistrationDto;
import com.example.Project.Example1.Student_Managment.dto.StudentResetPasswordDto;
import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import com.example.Project.Example1.Student_Managment.model.StudentResetPasswordModel;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface StudentDtoMapper {
    StudentRegistrationDto toDto(StudentRegisterModel model);
    StudentRegisterModel toModel(StudentRegistrationDto dto);
    StudentResetPasswordModel toModel(StudentResetPasswordDto dto);
}
