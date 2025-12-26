package com.example.Project.Example1.Staff_Management.repository;

import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Long> {

}
