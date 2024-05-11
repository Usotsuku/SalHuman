package com.example.salhumans.services;

import com.example.salhumans.models.Conge;
import com.example.salhumans.models.Employe;
import com.example.salhumans.models.Fiche_Paie;

import com.example.salhumans.models.Heure_Travaille;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeService {
    Employe saveEmployee(Employe employe);
    Employe updateEmploye(Employe employe);
    Employe getEmploye(Long id);
    List<Employe> getAllEmployes();
    void deleteEmployeById(Long id);
    void deleteAllEmployes();
    Employe getEmployeById(long id);

    Page<Employe> getAllEmployesByPage(int page, int size);
    void demanderConge(Conge conge);

    Fiche_Paie getLatestfichpaie(Employe employe) ;

    List<Heure_Travaille > getHeuresTravailByEmploye(Employe employe);
    public void approuverConge(Conge conge);
    public Conge getDemandeCongeById(Long congeId);
}
