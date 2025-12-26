package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.LevelHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelHelperRepository extends JpaRepository<LevelHelper,Long> {
}
