package com.example.salhumans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SalHumansApplication {

    public static void main(String[] args) {

        SpringApplication.run(SalHumansApplication.class, args);
    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public CommandLineRunner commandLineRunner(AccountService accountService){
//        return  args -> {
////            accountService.createUser("admin","123","admin@gmail.com","123");
////            accountService.createRole("ADMIN");
////            accountService.createRole("RH");
////            accountService.createRole("MANAGER");
////            accountService.createRole("EMPLOYE");
////            accountService.addRoletoUser("admin","ADMIN");
//        };
//    }
}
