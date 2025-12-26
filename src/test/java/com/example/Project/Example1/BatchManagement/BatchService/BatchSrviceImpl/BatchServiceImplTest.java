package com.example.Project.Example1.BatchManagement.BatchService.BatchSrviceImpl;

import com.example.Project.Example1.BatchManagement.BatchAdapter.BatchAdapter;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchModel.BatchCreateModel;
import com.example.Project.Example1.BatchManagement.Batchmapper.BatchEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BatchServiceImplTest {

    @Mock
    private BatchAdapter batchAdapter;

    @Mock
    private BatchEntityMapper batchEntityMapper;

    @InjectMocks
    private BatchServiceImpl batchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBatch_ShouldReturnCreatedModel() {
// Arrange: input model without id
        BatchCreateModel inputModel = new BatchCreateModel();
        inputModel.setBatchName("Test Batch");

// Entity before save
        BatchEntity entity = new BatchEntity();
        entity.setBatchName("Test Batch");

// Entity after save
        BatchEntity savedEntity = new BatchEntity();
        savedEntity.setBatchName("Test Batch");

// Expected output model
        BatchCreateModel expectedModel = new BatchCreateModel();
        expectedModel.setBatchName("Test Batch");

// Mock the dependencies
        when(batchEntityMapper.toEntity(inputModel)).thenReturn(entity);
        when(batchAdapter.saveBatch(entity)).thenReturn(savedEntity);
        when(batchEntityMapper.toModel(savedEntity)).thenReturn(expectedModel);

// Act
        BatchCreateModel result = batchService.createBatch(inputModel);

// Assert
        assertNotNull(result);
        assertEquals("Test Batch", result.getBatchName());

// Verify the sequence of calls
        verify(batchEntityMapper).toEntity(inputModel);
        verify(batchAdapter).saveBatch(entity);
        verify(batchEntityMapper).toModel(savedEntity);
    }
}
