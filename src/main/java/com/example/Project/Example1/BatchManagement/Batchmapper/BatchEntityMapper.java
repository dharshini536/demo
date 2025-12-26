package com.example.Project.Example1.BatchManagement.Batchmapper;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BatchEntityMapper {
    BatchCreateModel toModel(BatchEntity entiy);

    List<BatchCreateModel> toModel(List<BatchEntity> entiy);

    BatchEntity toEntity(BatchCreateModel model);
}
