package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsRepository;

import com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
