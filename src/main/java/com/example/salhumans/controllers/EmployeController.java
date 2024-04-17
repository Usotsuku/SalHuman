package com.example.salhumans.controllers;

import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.EmployeRepository;
import com.example.salhumans.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeController {
    @Autowired
    EmployeService employeService;

    @RequestMapping("/createEmploye")
    public String createEmploye(){
        return "CreateEmploye";
    }
    @RequestMapping("saveEmploye")
    public String saveEmploye(
            @ModelAttribute("employe")Employe employe,
            @RequestParam("dateJsp") String dateController,
            ModelMap modelMap
            )throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEmbauche = dateFormat.parse(String.valueOf(dateController));
        employe.setDate_embauche(dateEmbauche);
        Employe memo = employeService.saveEmployee(employe);
        String messageController = "the employe whose Id : " + memo.getEmployeId() + "is saved";

        modelMap.addAttribute("messageJsp",messageController);

        return "CreateEmploye";
    }
}
