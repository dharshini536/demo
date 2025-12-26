package com.example.Project.Example1.BatchManagement.BatchAdapter.BatchAdapterImpl;

import com.example.Project.Example1.BatchManagement.BatchAdapter.BatchAdapter;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchRepository.BatchRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BatchAdapterImpl implements BatchAdapter {
    private final BatchRepository batchRepository;

    public BatchAdapterImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public BatchEntity saveBatch(BatchEntity entity){
        return batchRepository.save(entity);
    }

    @Override
    public List<BatchEntity> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<BatchEntity> getBatchById(Long id) {
        return batchRepository.findById(id);
    }

    @Override
    public void deleteBatchById(Long id) {
        batchRepository.deleteById(id);
    }

    public List<BatchEntity> getBYCategory(Long batchId){
        return batchRepository.getBatchByCategoryId(batchId);
    }
}
