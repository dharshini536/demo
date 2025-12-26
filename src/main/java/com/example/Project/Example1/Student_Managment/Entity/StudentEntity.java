package com.example.Project.Example1.Student_Managment.Entity;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;

@Entity
@Table(name = "student_entity")
public class StudentEntity {

    @Id
    @Column(name = "student_id", unique = true)
    @GeneratedValue(generator = "student-id-gen")
    @GenericGenerator(
            name = "student-id-gen",
            strategy = "com.example.Project.Example1.Student_Managment.generator.StudentIdGenerator"
    )
    private String id;

    @Column(name = "student_firstName")
    private String firstName;

    @Column(name = "student_lastName")
    private String lastName;

    @Column(name = "email_id", unique = true, nullable = false)
    private String email;

    private Long age;

    @Column(unique = true)
    private String phoneNumber;

    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "roll_number", unique = true, nullable = false)
    private String rollNumber;

    private String department;
    private String gender;
    private String status;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_id", referencedColumnName = "secondary_details_id")
    private SecondaryDetails secondaryDetails;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level skillLevel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fee_id")
    private LevelHelper feeDetails;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getAge() { return age; }
    public void setAge(Long age) { this.age = age; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public SecondaryDetails getSecondaryDetails() { return secondaryDetails; }
    public void setSecondaryDetails(SecondaryDetails secondaryDetails) { this.secondaryDetails = secondaryDetails; }

    public Level getSkillLevel() { return skillLevel; }
    public void setSkillLevel(Level skillLevel) { this.skillLevel = skillLevel; }

    public LevelHelper getFeeDetails() { return feeDetails; }
    public void setFeeDetails(LevelHelper feeDetails) { this.feeDetails = feeDetails; }
}
