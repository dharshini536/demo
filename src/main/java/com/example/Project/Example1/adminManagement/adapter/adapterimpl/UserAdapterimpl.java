package com.example.Project.Example1.adminManagement.adapter.adapterimpl;

import com.example.Project.Example1.adminManagement.Repository.UserRepository;
import com.example.Project.Example1.adminManagement.adapter.UserAdapter;
import com.example.Project.Example1.adminManagement.entity.UserAccount;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserAdapterimpl implements UserAdapter {

    private final UserRepository userRepo;

    public UserAdapterimpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> findByMobileNumber(String mobileNumber) {
        return userRepo.findByMobileNumber(mobileNumber);
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
