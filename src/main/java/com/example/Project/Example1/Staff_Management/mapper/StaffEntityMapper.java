package com.example.Project.Example1.Staff_Management.mapper;

import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import com.example.Project.Example1.Staff_Management.model.StaffRegisterModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffEntityMapper {

    StaffRegisterModel toModel(StaffEntity entity);
    StaffEntity toEntity(StaffRegisterModel model);
}
