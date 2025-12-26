package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;

public class LevelCreateModel {
    private String levelName;
    private Long staffId;
    private Long batchId;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
