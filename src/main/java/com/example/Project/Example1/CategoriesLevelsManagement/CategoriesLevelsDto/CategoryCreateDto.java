package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class CategoryCreateDto {
    private String category;
    private String status;

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
