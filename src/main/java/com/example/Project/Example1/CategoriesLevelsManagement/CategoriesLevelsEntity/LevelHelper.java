package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity;

import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import jakarta.persistence.*;

    @Entity
    @Table(name = "level_helper")
    public class LevelHelper {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="fee_id")
        private Long id;
        @ManyToOne
        @JoinColumn(name = "level_id", nullable = false)
        private Level level;
        private Double amount;
        @OneToOne(mappedBy = "feeDetails")
        private StudentEntity student;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   }
