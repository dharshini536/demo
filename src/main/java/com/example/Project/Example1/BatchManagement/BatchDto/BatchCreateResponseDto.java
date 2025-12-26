package com.example.Project.Example1.BatchManagement.BatchDto;

import java.util.List;

public class BatchCreateResponseDto {
    private BatchSummery Summery;
    private List<BatchCreateDto> batch;

    public List<BatchCreateDto> getBatch() {
        return batch;
    }

    public void setBatch(List<BatchCreateDto> batch) {
        this.batch = batch;
    }

    public BatchSummery getSummery() {
        return Summery;
    }

    public void setSummery(BatchSummery summery) {
        Summery = summery;
    }
}
