package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsService;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel.*;

import java.util.List;

public interface CategoriesLevelsService {

    CategoryCreateModel createCategory(CategoryCreateModel categoryCreateModel);
    CategoryCreateModel getCategoryById(Long id);
    CategoryUpdateModel updateCategory(CategoryUpdateModel model);
    List<CategoryGetAllResponseModel> getAll();
    void deleteCategory(Long id);

    LevelCreateModel createLevels(LevelCreateModel levelCreateModel);
    LevelCreateModel getLevelById(Long id);
    List<LevelCreateModel> getAllLevels();
    List<LevelCreateModel> getLevelsByBatchId(Long batchId);
    LevelUpdateModel updateLevel(LevelUpdateModel model);
    void deleteLevelById(Long id);

    LevelHelperCreateModel createLevelHelper(LevelHelperCreateModel model);
    LevelHelperCreateModel getLevelHelperById(Long id);
    List<LevelHelperCreateModel> getAllLevelHelpers();
    LevelHelperUpdateModel updateLevelHelper(LevelHelperUpdateModel model);
    void deleteLevelHelperById(Long id);
}