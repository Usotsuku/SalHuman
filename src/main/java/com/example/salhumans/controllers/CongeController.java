package com.example.salhumans.controllers;

import com.example.salhumans.models.Conge;
import com.example.salhumans.models.Employe;
import com.example.salhumans.security.entities.User;

import com.example.salhumans.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CongeController {

    @Autowired
    private EmployeService employeService;
    @RequestMapping("/approuverConge")
    public String approuverConge(@RequestParam("congeId") Long congeId) {

        Conge conge = employeService.getDemandeCongeById(congeId);
        conge.setStatuts("APPROUVED");
        employeService.approuverConge(conge);
        return "redirect:/listeDemandesConges";
    }
}
