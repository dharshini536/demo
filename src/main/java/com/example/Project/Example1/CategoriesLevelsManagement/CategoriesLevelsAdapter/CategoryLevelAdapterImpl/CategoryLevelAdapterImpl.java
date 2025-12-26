package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsAdapter.CategoryLevelAdapterImpl;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsAdapter.CategoryLevelAdapter;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository.CategoryRepository;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository.LevelHelperRepository;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryLevelAdapterImpl implements CategoryLevelAdapter {
    private final CategoryRepository categoryRepository;
    private final LevelHelperRepository levelHelperRepository;
    private final LevelRepository levelRepository;
    public CategoryLevelAdapterImpl(CategoryRepository categoryRepository, LevelHelperRepository levelHelperRepository, LevelRepository levelRepository) {
        this.categoryRepository = categoryRepository;
        this.levelHelperRepository = levelHelperRepository;
        this.levelRepository = levelRepository;
    }


    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Level createLevel(Level entity) {
        return levelRepository.save(entity);
    }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public List<Level> getLevelsByBatchId(Long batchId) {
        return levelRepository.findByBatchId(batchId);
    }

    @Override
    public Level updateLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public void deleteLevelById(Long id) {
        levelRepository.deleteById(id);
    }

    @Override
    public LevelHelper createLevelHelper(LevelHelper levelHelper) {
        return levelHelperRepository.save(levelHelper);
    }

    @Override
    public LevelHelper getLevelHelperById(Long id) {
        return levelHelperRepository.findById(id).orElse(null);
    }

    @Override
    public List<LevelHelper> getAllLevelHelpers() {
        return levelHelperRepository.findAll();
    }

    @Override
    public LevelHelper updateLevelHelper(LevelHelper levelHelper) {
        return levelHelperRepository.save(levelHelper);
    }

    @Override
    public void deleteLevelHelperById(Long id) {
        levelHelperRepository.deleteById(id);
    }
}
