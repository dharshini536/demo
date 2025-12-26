package com.example.Project.Example1.Student_Managment.Service;

import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import com.example.Project.Example1.Student_Managment.model.StudentResetPasswordModel;


public interface StudentService {
    StudentRegisterModel saveStudent(StudentRegisterModel model);
    void resetPassword(StudentResetPasswordModel resetModel);

}
