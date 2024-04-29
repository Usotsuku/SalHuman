package com.example.salhumans.controllers;

import com.example.salhumans.models.Employe;
import com.example.salhumans.repositories.EmployeRepository;
import com.example.salhumans.security.entities.User;
import com.example.salhumans.security.services.UserService;
import com.example.salhumans.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class EmployeController {
    @Autowired
    EmployeService employeService;
    @Autowired
    UserService userService;

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
                                @RequestParam(name = "size",defaultValue = "10") int size
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
        Employe existingEmploye = employeService.getEmployeById(employe.getEmployeId());

        // Set the user of the existing employe to the employe being updated
        employe.setUser(existingEmploye.getUser());

        // Update the employe
        employeService.updateEmploye(employe);
        return "redirect:/editEmploye?id=" + employe.getEmployeId();
    }

    @RequestMapping("/profile")
    public String viewProfile(ModelMap model, Principal principal) {
        String userEmail = principal.getName();
        User user = userService.findUserByEmail(userEmail);
        Employe employe = user.getEmploye();
        model.addAttribute("employe", employe);
        return "profile";
    }
    @RequestMapping("/editProfile")
    public String editProfileForm(@RequestParam("id") long id, ModelMap modelMap) {

        Employe employe = employeService.getEmployeById(id);
        modelMap.addAttribute("employe", employe);
        return "editProfile";
    }

    @RequestMapping("/saveProfile")
    public String editProfileSubmit(@ModelAttribute("employe") Employe employe, Principal principal) {
        String userEmail = principal.getName();
        User user = userService.findUserByEmail(userEmail);
        employe.setUser(user);
        employeService.saveEmployee(employe);
        return "redirect:/profile";
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
