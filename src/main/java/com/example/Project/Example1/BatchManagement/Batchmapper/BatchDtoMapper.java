package com.example.Project.Example1.BatchManagement.Batchmapper;

import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateDto;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BatchDtoMapper {

    BatchCreateModel toModel(BatchCreateDto dto);

    BatchCreateDto toDto(BatchCreateModel model);

    List<BatchCreateDto> toDto(List<BatchCreateModel> model);
}
