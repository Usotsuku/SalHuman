package com.example.salhumans.security.repositories;

import com.example.salhumans.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByName(String name);
}
