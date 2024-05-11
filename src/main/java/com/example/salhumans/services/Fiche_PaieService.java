package com.example.salhumans.services;

import com.example.salhumans.models.Employe;
import org.springframework.stereotype.Service;

@Service

public interface Fiche_PaieService {
    void CalculerSalaire(Employe employe);
}
