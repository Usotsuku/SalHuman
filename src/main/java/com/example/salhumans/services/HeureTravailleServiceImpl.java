package com.example.salhumans.services;

import com.example.salhumans.models.Heure_Travaille;
import com.example.salhumans.repositories.HeureTravailleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HeureTravailleServiceImpl implements HeureTravailleService {
    @Autowired
    HeureTravailleRepository heureTravailleRepository;

    @Override
    public Heure_Travaille saveHeureTravaille(Heure_Travaille heureTravaille) {
        return heureTravailleRepository.save(heureTravaille);
    }

    @Override
    public Heure_Travaille updateHeureTravaille(Heure_Travaille heureTravaille) {
        return heureTravailleRepository.save(heureTravaille);
    }

    @Override
    public Heure_Travaille getHeureTravailleById(Long id) {
        Optional<Heure_Travaille> optionalHeureTravaille = heureTravailleRepository.findById(id);
        return optionalHeureTravaille.orElse(null);
    }

    @Override
    public Page<Heure_Travaille> getAllHeuresTravailleByPage(int page, int size) {
        return heureTravailleRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void deleteHeureTravailleById(Long id) {
        heureTravailleRepository.deleteById(id);
    }

    @Override
    public void deleteAllHeuresTravaille() {
        heureTravailleRepository.deleteAll();
    }
}
