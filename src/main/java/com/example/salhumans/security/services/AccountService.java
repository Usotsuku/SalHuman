package com.example.salhumans.security.services;

import com.example.salhumans.models.Employe;
import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface AccountService {
//    User createUser(User user,String confirmPassword);
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String newrole);
    void addRoletoUser(String username,String role);
    void removeRoletoUser(String username,String role);
    User loadUserByUsername(String username);
    List<Role> getAllRolles();
}
