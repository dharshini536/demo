package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level,Long> {
    List<Level> findByBatchId(Long batchId);
}
