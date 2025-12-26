package com.example.Project.Example1.adminManagement.dto;

import java.util.Set;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String username;
    private Set<String> roles;

    public UserResponse() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
