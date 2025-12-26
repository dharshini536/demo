package com.example.Project.Example1.Staff_Management.mapper;

import com.example.Project.Example1.Staff_Management.dto.StaffRegisterDto;
import com.example.Project.Example1.Staff_Management.model.StaffRegisterModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffDtoMapper {
    StaffRegisterModel toModel(StaffRegisterDto dto);
    StaffRegisterDto toDto(StaffRegisterModel model);
}
