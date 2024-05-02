package com.example.salhumans.services;
import java.util.Optional;

import com.example.salhumans.models.Conge;
import com.example.salhumans.models.Employe;
<<<<<<< HEAD
import com.example.salhumans.models.Heure_Travaille;

=======
>>>>>>> d0dcae846c9a704b60b825b3490539031306bf67
import com.example.salhumans.repositories.CongeRepository;
import com.example.salhumans.repositories.EmployeRepository;
import com.example.salhumans.repositories.HeureTravailleRepository;
import jakarta.transaction.Transactional;
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
    @Autowired
    CongeRepository congeRepository;

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

    @Override
    public void demanderConge(Conge conge) {
        congeRepository.save(conge);
    }
<<<<<<< HEAD




    @Autowired
    private HeureTravailleRepository  heureTravailRepository;

    @Override
    public List<Heure_Travaille > getHeuresTravailByEmploye(Employe employe) {

        return heureTravailRepository.findByEmploye(employe);
    }
    @Transactional
    public void approuverConge(Conge conge) {
        conge.setStatuts("APPROUVED");
        congeRepository.save(conge);
    }
    public Conge getDemandeCongeById(Long congeId) {
        return congeRepository.findById(congeId).orElse(null);
    }
=======
>>>>>>> d0dcae846c9a704b60b825b3490539031306bf67
}
