package com.example.salhumans.controllers;

import com.example.salhumans.models.Employe;
import com.example.salhumans.models.Fiche_Paie;
import com.example.salhumans.repositories.Fiche_PaieRepository;
import com.example.salhumans.services.EmployeService;
import com.example.salhumans.services.Fiche_PaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fiche_PaieController {


    @Autowired
    Fiche_PaieService fichePaieService;

    @Autowired
    EmployeService employeService;

    @RequestMapping("/calculate")
    public String calculeSalaire(@RequestParam("id") Long id, ModelMap modelMap){

        Employe employe = employeService.getEmployeById(id);

        fichePaieService.CalculerSalaire(employe);
        Fiche_Paie fiche = employeService.getLatestfichpaie(employe);
        modelMap.addAttribute("fiche",fiche);
        return "Bulletin";
    }
}
