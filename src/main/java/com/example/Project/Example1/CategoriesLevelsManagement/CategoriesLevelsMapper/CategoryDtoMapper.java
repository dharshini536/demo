package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsMapper;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsDto.*;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    CategoryCreateModel toModel(CategoryCreateDto dto);
    CategoryCreateDto toDto(CategoryCreateModel model);
    CategoryUpdateModel toModel(CategoryUpdateDto dto);
    CategoryUpdateDto toDto(CategoryUpdateModel model);
    List<CategoryGetAllResponse> toDto(List<CategoryGetAllResponseModel> model);

    @Mappings({
            @Mapping(target = "batch", ignore = true),
            @Mapping(target = "level", ignore = true)
    })
    LevelHelperCreateModel dtoToModel(LevelHelperCreateDto dto);

    @Mappings({
            @Mapping(target = "batchId", source = "batch.id"),
            @Mapping(target = "levelId", source = "level.id")
    })
    LevelHelperCreateDto modelToDto(LevelHelperCreateModel model);
    LevelHelperUpdateModel toModel(LevelHelperUpdateDto dto);
    LevelHelperUpdateDto toDto(LevelHelperUpdateModel model);

    LevelCreateModel toModel(LevelCreateDto dto);
    LevelCreateDto toDto(LevelCreateModel model);
    LevelUpdateModel toModel(LevelUpdateDto dto);
    LevelUpdateDto toDto(LevelUpdateModel model);
}
