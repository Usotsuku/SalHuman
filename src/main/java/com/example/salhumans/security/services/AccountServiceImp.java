//package com.example.salhumans.security.services;
//
//import com.example.salhumans.security.entities.Role;
//import com.example.salhumans.security.entities.User;
//import com.example.salhumans.security.repositories.RoleRepository;
//import com.example.salhumans.security.repositories.UserRepository;
//import jakarta.transaction.Transactional;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//@Service
//@AllArgsConstructor
//@Transactional
//public class AccountServiceImp implements AccountService{
//
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public User createUser(String username, String password, String email, String confirmPassword) {
////        User user = userRepository.findByUsername(username);
////        if(user!=null) throw new RuntimeException("Exist");
////        if(!password.equals(confirmPassword)) throw new RuntimeException("password not matching");
////        User newuser = new User();
////        newuser.setUserId(UUID.randomUUID().toString());
////        newuser.setUsername(username);
////        newuser.setPassword(passwordEncoder.encode(password));
////        newuser.setEmail(email);
////
////        return userRepository.save(newuser);
//
//        User user1 = userRepository.findByUsername(username);
//        if(user1!=null) throw new RuntimeException("Exist");
//        if(!password.equals(confirmPassword)) throw new RuntimeException("password not matching");
//        user1 = User.builder()
//                .name(username)
//                .password(passwordEncoder.encode(password))
//                .email(email)
//                .build();
//        return userRepository.save(user1);
//    }
//
////    @Override
////    public User createUser(User user,String confirmPassword) {
////        if(user!=null) throw new RuntimeException("Exist");
////        if(!password.equals(confirmPassword)) throw new RuntimeException("password not matching");
////        return userRepository.save(user);
////    }
//
//    @Override
//    public Role createRole(String newrole) {
//        Role role1 = roleRepository.findByNom(newrole);
//        if (role1 != null) {
//            // Role with this name already exists
//            return role1;
//        } else {
//            role1 = Role.builder()
//                    .name(newrole)
//                    .build();
//            return roleRepository.save(role1);
//        }
//    }
//
//    @Override
//    public void addRoletoUser(String username, String role) {
//        User user = userRepository.findByUsername(username);
//        Role role1 = roleRepository.findByNom(role);
//        if (user != null && role != null) {
//            // Ensure that the roles list is initialized
//            if (user.getRoles() == null) {
//                user.setRoles(new ArrayList<>());
//            }
//            user.getRoles().add(role1);
//            userRepository.save(user);
//        } else {
//            // Handle if user or role is not found
//            throw new IllegalArgumentException("User or role not found.");
//        }
//    }
//
//    @Override
//    public void removeRoletoUser(String username, String role) {
//        User user = userRepository.findByUsername(username);
//        Role role1 = roleRepository.findByNom(role);
//        user.getRoles().remove(role1);
//    }
//
//    @Override
//    public User loadUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<Role> getAllRolles() {
//        return roleRepository.findAll();
//    }
//}
