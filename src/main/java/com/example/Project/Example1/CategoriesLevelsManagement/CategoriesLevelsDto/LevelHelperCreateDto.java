package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto;

public class LevelHelperCreateDto {
    private Long batchId;
    private Long levelId;
    private Double amount;


    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
