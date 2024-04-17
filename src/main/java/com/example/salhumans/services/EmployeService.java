package com.example.salhumans.services;

import com.example.salhumans.models.Employe;
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
}
