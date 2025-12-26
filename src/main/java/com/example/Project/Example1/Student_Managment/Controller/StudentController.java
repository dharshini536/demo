package com.example.Project.Example1.Student_Managment.Controller;


import com.example.Project.Example1.Student_Managment.Facad.StudentFacad;
import com.example.Project.Example1.Student_Managment.Service.StudentService;
import com.example.Project.Example1.Student_Managment.dto.StudentRegistrationDto;
import com.example.Project.Example1.Auth_Management.apiResponse.ApiResponse;
import com.example.Project.Example1.Student_Managment.dto.StudentResetPasswordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentFacad studentFacad;

    public StudentController(StudentService studentService, StudentFacad studentFacad) {
        this.studentService = studentService;
        this.studentFacad = studentFacad;
    }

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse<StudentRegistrationDto>> addStudent(
            @RequestBody StudentRegistrationDto studentRegistrationDto) {
        StudentRegistrationDto savedDto = studentFacad.saveStudent(studentRegistrationDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Student Created Successfully", savedDto));
    }
    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<Void>> resetPassword(
            @RequestBody StudentResetPasswordDto resetPasswordRequest) {

        studentFacad.resetPassword(resetPasswordRequest);
        return ResponseEntity.ok(new ApiResponse<>(200, "Password reset successfully", null));
    }
}
