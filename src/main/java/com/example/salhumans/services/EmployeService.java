package com.example.salhumans.services;

import com.example.salhumans.models.Conge;
import com.example.salhumans.models.Employe;
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
    public void demanderConge(Conge conge);
}
