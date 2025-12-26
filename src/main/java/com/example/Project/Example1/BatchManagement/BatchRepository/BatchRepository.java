package com.example.Project.Example1.BatchManagement.BatchRepository;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity,Long> {

    List<BatchEntity> getBatchByCategoryId(Long BatchId);
}
