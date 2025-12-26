package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsFacad;

import com.example.Project.Example1.BatchManagement.BatchRepository.BatchRepository;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto.*;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsMapper.CategoryDtoMapper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel.*;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository.LevelRepository;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsService.CategoriesLevelsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryLevelFacad {
    private final CategoryDtoMapper categoryDtoMapper;
    private final CategoriesLevelsService categoriesLevelsService;
    private final LevelRepository levelRepository;


    public CategoryLevelFacad(CategoryDtoMapper categoryDtoMapper, CategoriesLevelsService categoriesLevelsService, LevelRepository levelRepository) {
        this.categoryDtoMapper = categoryDtoMapper;
        this.categoriesLevelsService = categoriesLevelsService;
        this.levelRepository = levelRepository;
    }

    public CategoryCreateDto createCategory(CategoryCreateDto  categoryCreateDto){
        CategoryCreateModel model = categoryDtoMapper.toModel(categoryCreateDto);
        CategoryCreateModel saveModel = categoriesLevelsService.createCategory(model);
        return categoryDtoMapper.toDto(saveModel);
    }
    public LevelHelperCreateDto createLevelHelper(LevelHelperCreateDto levelHelperCreateDto){
        LevelHelperCreateModel model = categoryDtoMapper.dtoToModel(levelHelperCreateDto);
        if (levelHelperCreateDto.getLevelId() != null) {
            model.setLevel(levelRepository.findById(levelHelperCreateDto.getLevelId())
                    .orElse(null));
        }
        LevelHelperCreateModel savedModel = categoriesLevelsService.createLevelHelper(model);
        return categoryDtoMapper.modelToDto(savedModel);
    }
    public LevelCreateDto createLevel(LevelCreateDto levelCreateDto){
        LevelCreateModel model = categoryDtoMapper.toModel(levelCreateDto);
        LevelCreateModel saveModel = categoriesLevelsService.createLevels(model);
        return categoryDtoMapper.toDto(saveModel);
    }
    public List<CategoryGetAllResponse> getAll(){
        return categoryDtoMapper.toDto(categoriesLevelsService.getAll());
    }
    public void deleteCategory(Long id){
        categoriesLevelsService.deleteCategory(id);
    }
    public CategoryCreateDto getCategoryById(Long id) {
        return categoryDtoMapper.toDto(categoriesLevelsService.getCategoryById(id));
    }

    public CategoryUpdateDto updateCategory(CategoryUpdateDto dto) {
        CategoryUpdateModel model = categoryDtoMapper.toModel(dto); // map DTO->Model (ensure method exists)
        CategoryUpdateModel updated = categoriesLevelsService.updateCategory(model);
        return categoryDtoMapper.toDto(updated);
    }

    public LevelCreateDto getLevelById(Long id) {
        return categoryDtoMapper.toDto(categoriesLevelsService.getLevelById(id));
    }

    public List<LevelCreateDto> getAllLevels() {
        return categoriesLevelsService.getAllLevels().stream().map(categoryDtoMapper::toDto).collect(Collectors.toList());
    }

    public List<LevelCreateDto> getLevelsByBatchId(Long batchId) {
        return categoriesLevelsService.getLevelsByBatchId(batchId).stream().map(categoryDtoMapper::toDto).collect(Collectors.toList());
    }

    public LevelUpdateDto updateLevel(LevelUpdateDto dto) {
        LevelUpdateModel model = categoryDtoMapper.toModel(dto);
        LevelUpdateModel updated = categoriesLevelsService.updateLevel(model);
        return categoryDtoMapper.toDto(updated);
    }

    public void deleteLevelById(Long id) {
        categoriesLevelsService.deleteLevelById(id);
    }

    public LevelHelperCreateDto getLevelHelperById(Long id) {
        return categoryDtoMapper.modelToDto(categoriesLevelsService.getLevelHelperById(id));
    }

    public List<LevelHelperCreateDto> getAllLevelHelpers() {
        return categoriesLevelsService.getAllLevelHelpers().stream().map(categoryDtoMapper::modelToDto).collect(Collectors.toList());
    }

    public LevelHelperUpdateDto updateLevelHelper(LevelHelperUpdateDto dto) {
        LevelHelperUpdateModel model = categoryDtoMapper.toModel(dto);
        LevelHelperUpdateModel updated = categoriesLevelsService.updateLevelHelper(model);
        return categoryDtoMapper.toDto(updated);
    }

    public void deleteLevelHelperById(Long id) {
        categoriesLevelsService.deleteLevelHelperById(id);
    }
}
