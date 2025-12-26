package com.example.Project.Example1.Student_Managment.model;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.Student_Managment.Entity.SecondaryDetails;
import java.time.LocalDate;

public class StudentRegisterModel {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Long age;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private String rollNumber;
    private String department;
    private String gender;
    private Long skillLevel;
    private String status;
    private SecondaryDetails secondaryDetails;

    public Long getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Long skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SecondaryDetails getSecondaryDetails() {
        return secondaryDetails;
    }

    public void setSecondaryDetails(SecondaryDetails secondaryDetails) {
        this.secondaryDetails = secondaryDetails;
    }
}