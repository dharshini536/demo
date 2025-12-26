package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
