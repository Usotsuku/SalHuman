package com.example.salhumans.security.services;

import com.example.salhumans.models.Employe;
import com.example.salhumans.security.dto.UserDto;
import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;
import com.example.salhumans.security.repositories.RoleRepository;
import com.example.salhumans.security.repositories.UserRepository;
import com.example.salhumans.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeService employeService;

    public UserServiceImp(UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public void saveUser(UserDto userDto ,String role) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        if (role.equals("ROLE_USER")) {
            Employe employe = new Employe();
            employe.setNom(userDto.getLastName());
            employe.setPrenom(userDto.getFirstName());
            employe.setUser(user);
            employeService.saveEmployee(employe);

            // Update the User entity with the associated Employe
            user.setEmploye(employe);
            userRepository.save(user);
        }

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public void addRoletoUser(String email, String role) {
        User user = userRepository.findByEmail(email);
        Role role1 = roleRepository.findByName(role);
        if (user != null && role != null) {
            // Ensure that the roles list is initialized
            if (user.getRoles() == null) {
                user.setRoles(new ArrayList<>());
            }
            user.getRoles().add(role1);
            userRepository.save(user);
        } else {
            // Handle if user or role is not found
            throw new IllegalArgumentException("User or role not found.");
        }
    }

    @Override
    public List<Role> getAllRolles() {
        return roleRepository.findAll();
    }
    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
