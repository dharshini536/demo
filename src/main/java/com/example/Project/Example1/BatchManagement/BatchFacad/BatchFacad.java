package com.example.Project.Example1.BatchManagement.BatchFacad;

import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateDto;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateResponseDto;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import com.example.Project.Example1.BatchManagement.BatchService.BatchService;
import com.example.Project.Example1.BatchManagement.Batchmapper.BatchDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BatchFacad {
    private final BatchService batchService;
    private final BatchDtoMapper batchDtoMapper;

    public BatchFacad(BatchService batchService, BatchDtoMapper batchDtoMapper) {
        this.batchService = batchService;
        this.batchDtoMapper = batchDtoMapper;
    }
    public BatchCreateDto crateBatch(BatchCreateDto batchCreateDto){
        BatchCreateModel  model = batchDtoMapper.toModel(batchCreateDto);
        BatchCreateModel savedModel = batchService.createBatch(model);
        return batchDtoMapper.toDto(savedModel);
    }
    public BatchCreateResponseDto getAllBatches() {
        return batchService.getAllBatches();
    }

    public Optional<BatchCreateDto> getBatchById(Long id){
        return batchService.getBatchById(id)
                .map(batchDtoMapper::toDto);
    }

    public BatchCreateDto updateBatch(Long id, BatchCreateDto dto){
        BatchCreateModel model = batchDtoMapper.toModel(dto);
        BatchCreateModel updated = batchService.updateBatch(id, model);
        return batchDtoMapper.toDto(updated);
    }

    public void deleteBatch(Long id){
        batchService.deleteBatch(id);
    }

    public List<BatchCreateDto> getByCtegoryId(Long id){

        return batchDtoMapper.toDto(batchService.getByCategoryId(id));
    }
}
