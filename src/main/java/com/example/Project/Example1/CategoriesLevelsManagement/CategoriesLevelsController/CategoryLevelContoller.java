package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsController;

import com.example.Project.Example1.Auth_Management.apiResponse.ApiResponse;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto.*;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsFacad.CategoryLevelFacad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryLevelContoller {
    private final CategoryLevelFacad categoryLevelFacad;

    public CategoryLevelContoller(CategoryLevelFacad categoryLevelFacad) {
        this.categoryLevelFacad = categoryLevelFacad;
    }

    @PostMapping("/create_category")
    public ResponseEntity<ApiResponse<CategoryCreateDto>>createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        CategoryCreateDto response=categoryLevelFacad.createCategory(categoryCreateDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Category Created Successfully", response));
    }
    @GetMapping("/get_all")
    public ResponseEntity<ApiResponse<List<CategoryGetAllResponse>>> getAll(){
        List<CategoryGetAllResponse> response=categoryLevelFacad.getAll();
        return ResponseEntity.ok(new ApiResponse<>(200,"Fetch All Categories",response));
    }
    @DeleteMapping("/delete_Category/{id}")
    public ResponseEntity<ApiResponse> getAllCategory(@PathVariable Long id){
        categoryLevelFacad.deleteCategory(id);
        return ResponseEntity.ok(new ApiResponse(200,"Category Delete Successfully",null));
    }
    @GetMapping("/get_Category/{id}")
    public ResponseEntity<ApiResponse<CategoryCreateDto>> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Category fetched", categoryLevelFacad.getCategoryById(id)));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<CategoryUpdateDto>> updateCategory(@RequestBody CategoryUpdateDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Category updated", categoryLevelFacad.updateCategory(dto)));
    }
    @PostMapping("/create_level_helper")
    public ResponseEntity<ApiResponse<LevelHelperCreateDto>> createLevelHelper(@RequestBody LevelHelperCreateDto levelHelperCreateDto) {
        LevelHelperCreateDto response=categoryLevelFacad.createLevelHelper(levelHelperCreateDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Fee Structure Created Successfully", response));
    }
    @GetMapping("/level_helper/{id}")
    public ResponseEntity<ApiResponse<LevelHelperCreateDto>> getLevelHelperById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "LevelHelper fetched", categoryLevelFacad.getLevelHelperById(id)));
    }

    @GetMapping("/level_helper")
    public ResponseEntity<ApiResponse<List<LevelHelperCreateDto>>> getAllLevelHelpers() {
        return ResponseEntity.ok(new ApiResponse<>(200, "All LevelHelpers", categoryLevelFacad.getAllLevelHelpers()));
    }

    @PutMapping("/level_helper/update")
    public ResponseEntity<ApiResponse<LevelHelperUpdateDto>> updateLevelHelper(@RequestBody LevelHelperUpdateDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(200, "LevelHelper updated", categoryLevelFacad.updateLevelHelper(dto)));
    }

    @DeleteMapping("/level_helper/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLevelHelper(@PathVariable Long id) {
        categoryLevelFacad.deleteLevelHelperById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "LevelHelper deleted", null));
    }

    @PostMapping("/create_Levels")
    public ResponseEntity<ApiResponse<LevelCreateDto>> createLevel(@RequestBody LevelCreateDto levelCreateDto) {
        LevelCreateDto response = categoryLevelFacad.createLevel(levelCreateDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Level Created Successfully", response));
    }
    @GetMapping("/levels/{id}")
    public ResponseEntity<ApiResponse<LevelCreateDto>> getLevelById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Level fetched", categoryLevelFacad.getLevelById(id)));
    }

    @GetMapping("/levels")
    public ResponseEntity<ApiResponse<List<LevelCreateDto>>> getAllLevels() {
        return ResponseEntity.ok(new ApiResponse<>(200, "All levels", categoryLevelFacad.getAllLevels()));
    }

    @GetMapping("/levels/batch/{batchId}")
    public ResponseEntity<ApiResponse<List<LevelCreateDto>>> getLevelsByBatchId(@PathVariable Long batchId) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Levels by batch", categoryLevelFacad.getLevelsByBatchId(batchId)));
    }

    @PutMapping("/levels/update")
    public ResponseEntity<ApiResponse<LevelUpdateDto>> updateLevel(@RequestBody LevelUpdateDto dto) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Level updated", categoryLevelFacad.updateLevel(dto)));
    }

    @DeleteMapping("/levels/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLevelById(@PathVariable Long id) {
        categoryLevelFacad.deleteLevelById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Level deleted", null));
    }


}
