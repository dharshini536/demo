package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto;

public class LevelHelperUpdateDto {
    private Long feeId;
    private Long levelId;
    private Double amount;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
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
