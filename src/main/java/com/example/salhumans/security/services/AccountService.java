package com.example.salhumans.security.services;

import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;
import org.springframework.stereotype.Service;

@Service

public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String role);
    void addRoletoUser(String username,String role);
    void removeRoletoUser(String username,String role);
    User loadUserByUsername(String username);
}
