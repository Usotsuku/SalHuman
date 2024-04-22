package com.example.salhumans.controllers;

import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.EmployeRepository;
import com.example.salhumans.services.EmployeService;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeController {
    @Autowired
    EmployeService employeService;

    @RequestMapping("/createEmploye")
    public String createEmploye(){
        return "CreateEmploye";
    }
    @RequestMapping("saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") Employe employe) {

        employeService.saveEmployee(employe);

        return "CreateEmploye";
    }
    @RequestMapping("/employeList")
    public String employeList(ModelMap modelMap,
                                @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "size",defaultValue = "1") int size
                                ){
        Page<Employe> employesController = employeService.getAllEmployesByPage(page, size);
        modelMap.addAttribute("employesJsp",employesController);
        modelMap.addAttribute("pages",new int[employesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "EmployeList";
    }
    @RequestMapping("/deleteEmploye")
    public String deleteEmploye(@RequestParam("id") Long id,ModelMap modelMap,
                                @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "size",defaultValue = "10") int size
    ){
        employeService.deleteEmployeById(id);
        Page<Employe> employesController = employeService.getAllEmployesByPage(page, size);
        modelMap.addAttribute("employesJsp",employesController);
        modelMap.addAttribute("pages",new int[employesController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "EmployeList";
    }

    @RequestMapping("/editEmploye")
    public String editEmploye(@RequestParam("id") long id, ModelMap modelMap) {
        Employe employeController = employeService.getEmployeById(id);
        modelMap.addAttribute("employeView", employeController);
        return "EditEmploye";
    }

    @RequestMapping(value = "/updateEmploye", method = RequestMethod.POST)
    public String updateEmploye(@ModelAttribute("employe") Employe employe) {
        employeService.updateEmploye(employe);
        return "redirect:/editEmploye?id=" + employe.getEmployeId();
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/employeList";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/accessDenied";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @Autowired
    EmployeRepository employeRepository;

    @GetMapping("/employedetails")
    public String employeDetails(@RequestParam("id") long id, ModelMap modelMap) {
        Employe employe = employeRepository.findById(id).orElse(null);

        if (employe != null) {
            modelMap.addAttribute("employe", employe);
            return "employedetails"; // Correction du nom de la vue
        } else {
            return "error"; // Vous devrez créer une page d'erreur appropriée
        }
    }
}
