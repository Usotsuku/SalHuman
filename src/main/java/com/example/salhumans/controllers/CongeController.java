package com.example.salhumans.controllers;

import com.example.salhumans.models.Conge;
import com.example.salhumans.models.Employe;
import com.example.salhumans.security.entities.User;
import com.example.salhumans.security.services.UserService;

import com.example.salhumans.services.EmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CongeController {

    @Autowired
    private EmployeService employeService;
    @Autowired
    UserService userService;

    @RequestMapping("/demandeConge")
    public String demandeCongeForm() {
        return "demandeConge";
    }

    @RequestMapping("/saveConge")
    public String demandeCongeSubmit(@ModelAttribute("conge") Conge conge, Principal principal) {

        // Get the email of the logged-in user
        String userEmail = principal.getName();

        // Retrieve the user by email
        User user = userService.findUserByEmail(userEmail);

        // Retrieve the employee associated with the user
        Employe employee = user.getEmploye();

        // Set the employee to the leave request
        conge.setEmploye(employee);

        // Set status as pending by default
        conge.setStatuts("PENDING");

        // Save the leave request
        employeService.demanderConge(conge);
        return "demandeConge";

    }
        @RequestMapping("/approuverConge")
        public String approuverConge(@RequestParam("congeId") Long congeId) {
            Conge conge = employeService.getDemandeCongeById(congeId);
            conge.setStatuts("APPROUVED");
            employeService.approuverConge(conge);
            return "redirect:/listeDemandesConges";
        }
    }