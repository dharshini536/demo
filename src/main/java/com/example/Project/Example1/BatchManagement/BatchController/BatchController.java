package com.example.Project.Example1.BatchManagement.BatchController;

import com.example.Project.Example1.Auth_Management.apiResponse.ApiResponse;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateDto;
import com.example.Project.Example1.BatchManagement.BatchDto.BatchCreateResponseDto;
import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchFacad.BatchFacad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batch")
public class BatchController {
    private final BatchFacad batchFacad;

    public BatchController(BatchFacad batchFacad) {
        this.batchFacad = batchFacad;
    }
    @PostMapping("/create_batch")
    public ResponseEntity<ApiResponse  <BatchCreateDto>> createBatch(@RequestBody BatchCreateDto batchCreateDto){
        BatchCreateDto response=batchFacad.crateBatch(batchCreateDto);
        return ResponseEntity.ok(new ApiResponse<>(200,"batch create success",response));
    }

    @GetMapping("/get_all")
    public ResponseEntity<ApiResponse<BatchCreateResponseDto>> getAllBatches() {
        BatchCreateResponseDto response = batchFacad.getAllBatches();
        return ResponseEntity.ok(new ApiResponse<>(200, "Fetched all batches", response));
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<ApiResponse<BatchCreateDto>> getBatchById(@PathVariable Long id){
        return batchFacad.getBatchById(id)
                .map(dto -> ResponseEntity.ok(new ApiResponse<>(200, "Fetched batch successfully", dto)))
                .orElse(ResponseEntity.status(404).body(new ApiResponse<>(404, "Batch not found", null)));
    }
    @GetMapping("/getBYCategoryId/{id}")
    public ResponseEntity<ApiResponse<List<BatchCreateDto>>> getByCategoryId(@PathVariable Long id){
        List<BatchCreateDto> result=batchFacad.getByCtegoryId(id);
        return ResponseEntity.ok(new ApiResponse<>(200,"Fetch Batch Details By Category Id",result));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<BatchCreateDto>> updateBatch(
            @PathVariable Long id,
            @RequestBody BatchCreateDto batchCreateDto){
        BatchCreateDto response = batchFacad.updateBatch(id, batchCreateDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Batch updated successfully", response));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBatch(@PathVariable Long id){
        batchFacad.deleteBatch(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Batch deleted successfully", "Deleted"));
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
