package com.example.Project.Example1.adminManagement.adapter;

import com.example.Project.Example1.adminManagement.entity.UserAccount;

import java.util.Optional;

public interface UserAdapter {
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByMobileNumber(String mobileNumber);
    Optional<UserAccount> findByUsername(String username);

}
