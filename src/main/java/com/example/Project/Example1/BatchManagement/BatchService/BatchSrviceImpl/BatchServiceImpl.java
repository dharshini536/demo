package com.example.Project.Example1.BatchManagement.BatchService.BatchSrviceImpl;

import com.example.Project.Example1.BatchManagement.BatchAdapter.BatchAdapter;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateDto;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateResponseDto;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchSummery;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import com.example.Project.Example1.BatchManagement.Batchmapper.BatchDtoMapper;
import com.example.Project.Example1.BatchManagement.Batchmapper.BatchEntityMapper;
import com.example.Project.Example1.adminManagement.Repository.RoleRepository;
import com.example.Project.Example1.adminManagement.Repository.UserRepository;
import com.example.Project.Example1.adminManagement.adapter.UserAdapter;
import com.example.Project.Example1.adminManagement.entity.Role;
import com.example.Project.Example1.adminManagement.entity.UserAccount;
import com.example.Project.Example1.BatchManagement.BatchService.BatchService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {
    private final BatchAdapter batchAdapter;
    private final BatchEntityMapper batchEntityMapper;
    private final BatchDtoMapper batchDtoMapper;

    public BatchServiceImpl(BatchAdapter batchAdapter, BatchEntityMapper batchEntityMapper, BatchDtoMapper batchDtoMapper) {
        this.batchAdapter = batchAdapter;
        this.batchEntityMapper = batchEntityMapper;
        this.batchDtoMapper = batchDtoMapper;
    }

    @Override
    public BatchCreateModel createBatch(BatchCreateModel batchCreateModel) {
        BatchEntity entity = batchEntityMapper.toEntity(batchCreateModel);
        BatchEntity savedEntity = batchAdapter.saveBatch(entity);
        return batchEntityMapper.toModel(savedEntity);
    }

    @Override
    public BatchCreateResponseDto getAllBatches() {
        List<BatchCreateModel> models = batchAdapter.getAllBatches()
                .stream()
                .map(batchEntityMapper::toModel)
                .toList();

        List<BatchCreateDto> dtoList = models.stream()
                .map(batchDtoMapper::toDto)
                .toList();

        long total = dtoList.size();
        long activeCount = dtoList.stream()
                .filter(b -> "Active".equalsIgnoreCase(b.getStatus()))
                .count();
        long inactiveCount = total - activeCount;

        BatchSummery summery = new BatchSummery();
        summery.setTotalCount(total);
        summery.setActiveBatch(activeCount);
        summery.setInActiveBatch(inactiveCount);

        BatchCreateResponseDto response = new BatchCreateResponseDto();
        response.setSummery(summery);
        response.setBatch(dtoList);

        return response;
    }

    @Override
    public Optional<BatchCreateModel> getBatchById(Long id) {
        return batchAdapter.getBatchById(id)
                .map(batchEntityMapper::toModel);
    }

    @Override
    public BatchCreateModel updateBatch(Long id, BatchCreateModel model) {
        BatchEntity existing = batchAdapter.getBatchById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found with id: " + id));

        existing.setBatchName(model.getBatchName());
        existing.setCategory(model.getCategory());
        existing.setStartDate(model.getStartDate());
        existing.setEndDate(model.getEndDate());
        existing.setStatus(model.getStatus());

        BatchEntity updated = batchAdapter.saveBatch(existing);
        return batchEntityMapper.toModel(updated);
    }

    @Override
    public void deleteBatch(Long id) {
        batchAdapter.deleteBatchById(id);
    }

    @Override
    public List<BatchCreateModel> getByCategoryId(Long id){
        List<BatchCreateModel> model = batchEntityMapper.toModel(batchAdapter.getBYCategory(id));
    return model;
    }
}