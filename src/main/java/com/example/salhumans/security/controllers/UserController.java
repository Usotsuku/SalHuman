package com.example.salhumans.security.controllers;

import ch.qos.logback.core.model.Model;
import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/createUser")
    public String CreateUser(ModelMap modelMap) {
        List<Role> roles = accountService.getAllRolles();
        modelMap.addAttribute("rolesView", roles);
        return "CreateUser";
    }

    @RequestMapping("/saveUser")
    public String createUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email,
                             @RequestParam String confirmPassword,
                             @RequestParam String role) {

        accountService.createUser(username, password, email, confirmPassword);

        accountService.addRoletoUser(username, role);

        return "CreateUser";
    }
}
