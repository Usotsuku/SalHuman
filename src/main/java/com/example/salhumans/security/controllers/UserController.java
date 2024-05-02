package com.example.salhumans.security.controllers;

import ch.qos.logback.core.model.Model;
import com.example.salhumans.models.Employe;
import com.example.salhumans.security.dto.UserDto;
import com.example.salhumans.security.entities.Role;
import com.example.salhumans.security.entities.User;
import com.example.salhumans.security.services.UserService;
import com.example.salhumans.services.EmployeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeService employeService;

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


    @RequestMapping("/createUser")
    public String showRegistrationForm(ModelMap modelmap){
        // create model object to store form data
        UserDto user = new UserDto();
        List<Role> roles = userService.getAllRolles();
        modelmap.addAttribute("rolesView", roles);
        modelmap.addAttribute("user", user);
        return "createUser";
    }
    @RequestMapping("/saveUser")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               @RequestParam String role,
                               BindingResult result,
                               ModelMap model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "createUser";
        }

        userService.saveUser(userDto,role);

        userService.addRoletoUser(userDto.getEmail(),role);
        return "/login";
    }
}
