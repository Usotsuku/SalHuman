package com.example.salhumans.security.services;

import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;
import com.example.salhumans.security.repositories.RoleRepository;
import com.example.salhumans.security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImp implements AccountService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {
//        User user = new User();
//        user.setUserId(Long.valueOf(UUID.randomUUID().toString()));
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setEmail(email);
//        return userRepository.save(user);
        User user = userRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("Exist");
        if(!password.equals(confirmPassword)) throw new RuntimeException("password not matching");

        user = User.builder()
                .userId(Long.valueOf(UUID.randomUUID().toString()))
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return userRepository.save(user);
    }

    @Override
    public Role createRole(String role) {
        Role role1 = roleRepository.findByNom(role);
        if (role1 != null) {
            // Role with this name already exists
            return role1;
        } else {
            role1 = Role.builder()
                    .roleId(Long.valueOf(UUID.randomUUID().toString()))
                    .nom(role)
                    .build();
            return roleRepository.save(role1);
        }
    }

    @Override
    public void addRoletoUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByNom(role);
        user.getRoles().add(role1);

    }

    @Override
    public void removeRoletoUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByNom(role);
        user.getRoles().remove(role1);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
