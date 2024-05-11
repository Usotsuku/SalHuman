package com.example.salhumans.controllers;
import ch.qos.logback.core.model.Model;
import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.HeureTravailleRepository;
import com.example.salhumans.services.EmployeService;
import com.example.salhumans.services.HeureTravailleService;


import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.salhumans.models.Heure_Travaille;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;

import java.util.Optional;

@Controller

public class Heure_TravailleController {
    @Autowired
    HeureTravailleService heureTravailleService;
    @Autowired
    EmployeService employeService;
    @Autowired
    private HeureTravailleRepository  heuresTravailRepository;


    @RequestMapping("/createHeureTravaille")
    public String createHeureTravaille(ModelMap model) {
        List<Employe> employes = employeService.getAllEmployes();
        model.addAttribute("employes", employes);
        return "CreateHeureTravaille";
    }

    @RequestMapping("saveHeureTravaille")
    public String saveHeureTravaille(@ModelAttribute("heureTravaille") Heure_Travaille heureTravaille) {
        heureTravailleService.saveHeureTravaille(heureTravaille);
        return "redirect:/createHeureTravaille";
    }


    @RequestMapping("/deleteHeureTravaille")
    public String deleteHeureTravaille(@RequestParam("id") Long id, ModelMap modelMap,
                                       @RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "10") int size) {
        heureTravailleService.deleteHeureTravailleById(id);
        return "redirect:/heureTravailleList?page=" + page + "&size=" + size;
    }
    @GetMapping("/heuresTravail/{employeId}")
    public String listerHeuresTravailEmploye(@PathVariable Long employeId, ModelMap model) {
        Employe employe = employeService.getEmployeById(employeId);
        if (employe == null) {
            // Gérer le cas où l'employé n'est pas trouvé, par exemple, rediriger vers une page d'erreur
            return "redirect:/erreur";
        }

        List<Heure_Travaille> heuresTravail = employeService.getHeuresTravailByEmploye(employe);

        model.addAttribute("employe", employe);
        model.addAttribute("heuresTravail", heuresTravail);

        return "listeHeuresTravailEmploye";
    }
    @RequestMapping("/approuverHeureTravaille")
    public String approuverHeureTravaille(@RequestParam("heureTravailleId") Long heureTravailleId) {
        // Retrouver l'heure de travail par son identifiant
        Heure_Travaille heureTravaille = heureTravailleService.getHeureTravailleById(heureTravailleId);

        // Mettre à jour le statut de l'heure de travail à "Approuvé"
        heureTravaille.setStatut("APPROUVED");

        // Sauvegarder l'heure de travail mise à jour
        heureTravailleService.saveHeureTravaille(heureTravaille);

        return "redirect:/heureTravailleList"; // Redirection vers une page qui liste toutes les heures de travail
    }

}

