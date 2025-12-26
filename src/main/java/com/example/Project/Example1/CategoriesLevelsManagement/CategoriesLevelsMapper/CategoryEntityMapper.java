package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsMapper;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto.LevelHelperResponseDto;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto.LevelResponseDto;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    @Mapping(target = "id", ignore = true)
    CategoryEntity toEntityFromCreateModel(CategoryCreateModel model);

    CategoryCreateModel entityToCreateModel(CategoryEntity entity);

    List<CategoryGetAllResponseModel> entityListToGetAllModels(List<CategoryEntity> entityList);

    @Mapping(target = "id", ignore = true)
    CategoryEntity toEntityFromUpdateModel(CategoryUpdateModel model);

    CategoryUpdateModel entityToUpdateModel(CategoryEntity entity);



    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "maps", ignore = true),
            @Mapping(target = "batch", ignore = true),
            @Mapping(target = "staff", ignore = true)
    })
    Level toEntityFromCreateLevelModel(LevelCreateModel model);

    @Mappings({
            @Mapping(target = "staffId", source = "staff.staffId"),
            @Mapping(target = "batchId", source = "batch.id")
    })
    LevelCreateModel entityToCreateLevelModel(Level entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "maps", ignore = true),
            @Mapping(target = "batch", ignore = true),
            @Mapping(target = "staff", ignore = true)
    })
    Level toEntityFromUpdateLevelModel(LevelUpdateModel model);

    @Mappings({
            @Mapping(target = "staffId", source = "staff.staffId"),
            @Mapping(target = "batchId", source = "batch.id")
    })
    LevelUpdateModel entityToUpdateLevelModel(Level entity);



    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "level", ignore = true),
            @Mapping(target = "student", ignore = true)
    })
    LevelHelper toEntityFromCreateLevelHelperModel(LevelHelperCreateModel model);

    LevelHelperCreateModel entityToCreateLevelHelperModel(LevelHelper entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "student", ignore = true),
            @Mapping(target = "level", ignore = true)
    })
    LevelHelper toEntityFromUpdateLevelHelperModel(LevelHelperUpdateModel model);

    @Mapping(target = "feeId", source = "id")
    LevelHelperUpdateModel entityToUpdateLevelHelperModel(LevelHelper entity);

}