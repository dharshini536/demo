package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;

public class LevelHelperCreateModel {
    private BatchEntity batch;
    private Level level;
    private Double amount;

    public BatchEntity getBatch() {
        return batch;
    }

    public void setBatch(BatchEntity batch) {
        this.batch = batch;
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
}
