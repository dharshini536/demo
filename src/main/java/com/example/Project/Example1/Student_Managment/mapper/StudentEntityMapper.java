package com.example.Project.Example1.Student_Managment.mapper;

import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import com.example.Project.Example1.Student_Managment.model.StudentRegisterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentEntityMapper {
    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "feeDetails", ignore = true),
            @Mapping(target = "skillLevel.id", source = "skillLevel")
    })
    StudentEntity toEntity(StudentRegisterModel model);

    @Mapping(target = "skillLevel", source = "skillLevel.id")
    StudentRegisterModel toModel(StudentEntity entity);
}
