package com.example.salhumans.repositories;
import com.example.salhumans.models.Employe;
import com.example.salhumans.models.Heure_Travaille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeureTravailleRepository extends JpaRepository<Heure_Travaille, Long> {


    List<Heure_Travaille> findByEmploye(Employe employe);
}

