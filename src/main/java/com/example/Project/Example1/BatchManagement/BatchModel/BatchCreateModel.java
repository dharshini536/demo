package com.example.Project.Example1.BatchManagement.BatchModel;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;

import java.time.LocalDate;

public class BatchCreateModel {
    private String batchName;
    private CategoryEntity category;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
