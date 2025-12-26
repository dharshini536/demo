package com.example.Project.Example1.Student_Managment.Adapter;

import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;

import java.util.Optional;

public interface StudentAdapter {
    StudentEntity SaveStudent(StudentEntity entity);
    Optional<StudentEntity> findByEmail(String email);
    int resetPassword(String email, String encodedPassword);
}
