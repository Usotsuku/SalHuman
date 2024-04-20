package com.example.salhumans.services;
import java.util.Optional;
import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.EmployeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public Employe getEmployeById(long id) {
        Optional<Employe> optionalEmploye = employeRepository.findById(id);
        return optionalEmploye.orElse(null);
    }

    @Override
    public Page<Employe> getAllEmployesByPage(int page, int size) {
        return employeRepository.findAll(PageRequest.of(page, size));
    }
}
