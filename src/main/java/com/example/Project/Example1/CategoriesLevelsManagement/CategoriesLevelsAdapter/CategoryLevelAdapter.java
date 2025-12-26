package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsAdapter;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;

import java.util.List;

public interface CategoryLevelAdapter {
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    LevelHelper createLevelHelper(LevelHelper levelHelper);
    Level createLevel(Level entity);
    List<CategoryEntity> getAll();
    void deleteCategory(Long id);

    CategoryEntity getCategoryById(Long id);
    CategoryEntity updateCategory(CategoryEntity entity);

    Level getLevelById(Long id);
    List<Level> getAllLevels();
    List<Level> getLevelsByBatchId(Long batchId);
    Level updateLevel(Level level);
    void deleteLevelById(Long id);

    LevelHelper getLevelHelperById(Long id);
    List<LevelHelper> getAllLevelHelpers();
    LevelHelper updateLevelHelper(LevelHelper levelHelper);
    void deleteLevelHelperById(Long id);

}
