package com.example.Project.Example1.BatchManagement.BatchService;

import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateResponseDto;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import com.example.Project.Example1.adminManagement.entity.Role;
import com.example.Project.Example1.adminManagement.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface BatchService {
    BatchCreateModel createBatch(BatchCreateModel batchCreateModel);
    BatchCreateResponseDto getAllBatches();
    Optional<BatchCreateModel> getBatchById(Long id);
    BatchCreateModel updateBatch(Long id, BatchCreateModel model);
    void deleteBatch(Long id);
    List<BatchCreateModel> getByCategoryId(Long id);
}

