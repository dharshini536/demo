package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsService.CategoriesLevelsServiceImpl;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.BatchManagement.BatchRepository.BatchRepository;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsAdapter.CategoryLevelAdapter;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsMapper.CategoryEntityMapper;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsModel.*;
import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsService.CategoriesLevelsService;
import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import com.example.Project.Example1.Staff_Management.repository.StaffRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoriesLevelsServiceImpl implements CategoriesLevelsService {

    private final CategoryLevelAdapter adapter;
    private final CategoryEntityMapper mapper;
    private final StaffRepository staffRepository;
    private final BatchRepository batchRepository;

    public CategoriesLevelsServiceImpl(CategoryLevelAdapter adapter,
                                       CategoryEntityMapper mapper,
                                       StaffRepository staffRepository,
                                       BatchRepository batchRepository) {
        this.adapter = adapter;
        this.mapper = mapper;
        this.staffRepository = staffRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public CategoryCreateModel createCategory(CategoryCreateModel categoryCreateModel) {
        CategoryEntity entity = mapper.toEntityFromCreateModel(categoryCreateModel);
        CategoryEntity saved = adapter.createCategory(entity);
        return mapper.entityToCreateModel(saved);
    }

    @Override
    public CategoryCreateModel getCategoryById(Long id) {
        CategoryEntity entity = adapter.getCategoryById(id);
        if (entity == null) throw new RuntimeException("Category not found with id: " + id);
        return mapper.entityToCreateModel(entity);
    }

    @Override
    @Transactional
    public CategoryUpdateModel updateCategory(CategoryUpdateModel model) {
        if (model.getId() == null) throw new RuntimeException("Category id required for update");
        CategoryEntity existing = adapter.getCategoryById(model.getId());
        if (existing == null) throw new RuntimeException("Category not found with id: " + model.getId());
        existing.setCategory(model.getCategory());
        existing.setStatus(model.getStatus());
        CategoryEntity saved = adapter.updateCategory(existing);
        return mapper.entityToUpdateModel(saved);
    }

    @Override
    public List<CategoryGetAllResponseModel> getAll() {
        return mapper.entityListToGetAllModels(adapter.getAll());
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        adapter.deleteCategory(id);
    }

    @Override
    public LevelCreateModel createLevels(LevelCreateModel levelCreateModel) {
        Level entity = mapper.toEntityFromCreateLevelModel(levelCreateModel);
        if (levelCreateModel.getStaffId() != null) {
            StaffEntity staff = staffRepository.findById(levelCreateModel.getStaffId())
                    .orElseThrow(() -> new UsernameNotFoundException("Staff not found"));
            entity.setStaff(staff);
        }
        if (levelCreateModel.getBatchId() != null) {
            BatchEntity batch = batchRepository.findById(levelCreateModel.getBatchId())
                    .orElseThrow(() -> new RuntimeException("Batch not found"));
            entity.setBatch(batch);
        }
        Level saved = adapter.createLevel(entity);
        return mapper.entityToCreateLevelModel(saved);
    }

    @Override
    public LevelCreateModel getLevelById(Long id) {
        Level entity = adapter.getLevelById(id);
        if (entity == null) throw new RuntimeException("Level not found");
        return mapper.entityToCreateLevelModel(entity);
    }

    @Override
    public List<LevelCreateModel> getAllLevels() {
        return adapter.getAllLevels().stream().map(mapper::entityToCreateLevelModel).collect(Collectors.toList());
    }

    @Override
    public List<LevelCreateModel> getLevelsByBatchId(Long batchId) {
        return adapter.getLevelsByBatchId(batchId).stream().map(mapper::entityToCreateLevelModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LevelUpdateModel updateLevel(LevelUpdateModel model) {
        if (model.getId() == null) throw new RuntimeException("Level id required for update");
        Level existing = adapter.getLevelById(model.getId());
        if (existing == null) throw new RuntimeException("Level not found with id: " + model.getId());

        if (model.getLevelName() != null) existing.setLevelName(model.getLevelName());

        if (model.getStaffId() != null) {
            StaffEntity staff = staffRepository.findById(model.getStaffId())
                    .orElseThrow(() -> new UsernameNotFoundException("Staff not found"));
            existing.setStaff(staff);
        }
        if (model.getBatchId() != null) {
            BatchEntity batch = batchRepository.findById(model.getBatchId())
                    .orElseThrow(() -> new RuntimeException("Batch not found"));
            existing.setBatch(batch);
        }

        Level saved = adapter.updateLevel(existing);
        return mapper.entityToUpdateLevelModel(saved);
    }

    @Override
    @Transactional
    public void deleteLevelById(Long id) {
        Level level = adapter.getLevelById(id);
        if (level == null) {
            throw new RuntimeException("Level not found with id: " + id);
        }

        if (level.getMaps() != null && !level.getMaps().isEmpty()) {
            level.getMaps().forEach(helper -> helper.setLevel(null));
            level.getMaps().clear();
        }


        adapter.deleteLevelById(id);
    }

    @Override
    public LevelHelperCreateModel createLevelHelper(LevelHelperCreateModel model) {
        LevelHelper entity = mapper.toEntityFromCreateLevelHelperModel(model);
        if (model.getLevel() != null) {
            entity.setLevel(model.getLevel());
        }
        LevelHelper saved = adapter.createLevelHelper(entity);
        return mapper.entityToCreateLevelHelperModel(saved);
    }

    @Override
    public LevelHelperCreateModel getLevelHelperById(Long id) {
        LevelHelper entity = adapter.getLevelHelperById(id);
        if (entity == null) throw new RuntimeException("LevelHelper not found");
        return mapper.entityToCreateLevelHelperModel(entity);
    }

    @Override
    public List<LevelHelperCreateModel> getAllLevelHelpers() {
        return adapter.getAllLevelHelpers().stream().map(mapper::entityToCreateLevelHelperModel).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LevelHelperUpdateModel updateLevelHelper(LevelHelperUpdateModel model) {
        if (model.getFeeId() == null) throw new RuntimeException("feeId required for update");
        LevelHelper existing = adapter.getLevelHelperById(model.getFeeId());
        if (existing == null) throw new RuntimeException("LevelHelper not found with id: " + model.getFeeId());

        if (model.getAmount() != null) existing.setAmount(model.getAmount());

        if (model.getLevel().getId() != null) {
            Level level = adapter.getLevelById(model.getLevel().getId());
            if (level == null) throw new RuntimeException("Level not found with id: " + model.getLevel().getId());
            existing.setLevel(level);
        }

        LevelHelper saved = adapter.updateLevelHelper(existing);
        return mapper.entityToUpdateLevelHelperModel(saved);
    }

    @Override
    @Transactional
    public void deleteLevelHelperById(Long id) {
        adapter.deleteLevelHelperById(id);
    }
}