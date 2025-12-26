package com.example.Project.Example1.Student_Managment.Adapter.Impl;

import com.example.Project.Example1.Student_Managment.Adapter.StudentAdapter;
import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import com.example.Project.Example1.Student_Managment.Repositoty.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentAdapterImpl implements StudentAdapter {

    private final StudentRepository studentRepository;

    public StudentAdapterImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity SaveStudent(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    @Override
    public Optional<StudentEntity> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public int resetPassword(String email, String encodedPassword) {
        return studentRepository.updatePasswordByEmail(email, encodedPassword);
    }



}
