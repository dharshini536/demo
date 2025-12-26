package com.example.Project.Example1.adminManagement.Repository;


import com.example.Project.Example1.adminManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(String name);
    }

