package com.example.salhumans.repositories;

import com.example.salhumans.models.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {
}
