package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;

import java.time.LocalDate;

public class CategoryCreateModel {
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
