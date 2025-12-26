package com.example.Project.Example1.adminManagement.Repository;


import com.example.Project.Example1.adminManagement.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByMobileNumber(String mobileNumber);
}
