package com.example.salhumans.security.services;

import com.example.salhumans.security.dto.UserDto;
import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto,String role);

    void addRoletoUser(String email, String role);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
    public List<Role> getAllRolles();
}
