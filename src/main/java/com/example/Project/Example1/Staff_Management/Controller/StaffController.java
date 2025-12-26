package com.example.Project.Example1.Staff_Management.Controller;

import com.example.Project.Example1.Auth_Management.apiResponse.ApiResponse;
import com.example.Project.Example1.Staff_Management.dto.StaffRegisterDto;
import com.example.Project.Example1.Staff_Management.facad.StaffFacad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffFacad staffFacad;

    public StaffController(StaffFacad staffFacad) {
        this.staffFacad = staffFacad;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<StaffRegisterDto>> createStaff(@RequestBody StaffRegisterDto staffRegisterDto) {
        StaffRegisterDto response = staffFacad.createStaff(staffRegisterDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Staff Created Successfully", response));
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Staff!";
    }
}


