package com.example.Project.Example1.adminManagement.Mapper;

import com.example.Project.Example1.adminManagement.dto.UserRegisterRequest;
import com.example.Project.Example1.adminManagement.dto.UserResponse;
import com.example.Project.Example1.adminManagement.entity.UserAccount;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserAccount toEntity(UserRegisterRequest req) {
        UserAccount u = new UserAccount();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setUsername(req.getUsername());
        u.setPassword(req.getPassword());
        return u;
    }

    public static UserResponse toDto(UserAccount user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles().stream()
                .map(r -> r.getName())
                .collect(Collectors.toSet()));
        return dto;
    }

}
