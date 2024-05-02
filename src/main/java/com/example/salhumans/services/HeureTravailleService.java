package com.example.salhumans.services;

import com.example.salhumans.models.Heure_Travaille;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HeureTravailleService {
    Heure_Travaille saveHeureTravaille(Heure_Travaille heureTravaille);
    Heure_Travaille updateHeureTravaille(Heure_Travaille heureTravaille);
    Heure_Travaille getHeureTravailleById(Long id);
    Page<Heure_Travaille> getAllHeuresTravailleByPage(int page, int size);
    void deleteHeureTravailleById(Long id);
    void deleteAllHeuresTravaille();

}
