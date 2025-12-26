package com.example.Project.Example1.BatchManagement.BatchAdapter;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;

import java.util.List;
import java.util.Optional;

public interface BatchAdapter {
    BatchEntity saveBatch(BatchEntity entity);
    List<BatchEntity> getAllBatches();
    Optional<BatchEntity> getBatchById(Long id);
    void deleteBatchById(Long id);
    List<BatchEntity> getBYCategory(Long batchId);
}
