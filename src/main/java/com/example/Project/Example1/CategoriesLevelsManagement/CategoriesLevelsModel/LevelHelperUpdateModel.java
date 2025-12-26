package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;

public class LevelHelperUpdateModel {
    private Long feeId;
    private Level level;
    private Double amount;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
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
