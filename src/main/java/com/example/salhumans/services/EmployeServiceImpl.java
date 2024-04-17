package com.example.salhumans.services;

import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.EmployeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    EmployeRepository employeRepository;
    @Override
    public Employe saveEmployee(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmploye(Long id) {
        return employeRepository.findById(id).get();
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteEmployeById(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployes() {
        employeRepository.deleteAll();
    }
}