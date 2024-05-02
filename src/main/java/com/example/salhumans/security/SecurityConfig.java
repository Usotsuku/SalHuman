package com.example.salhumans.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/createUser","/saveUser").permitAll()
                        .requestMatchers("/createEmploye","/saveEmploye").hasAnyAuthority("ROLE_ADMIN","ROLE_RH")
                        .requestMatchers("/employedetails","/updateEmploye","/deleteEmploye","/editEmploye").hasAnyAuthority("ROLE_ADMIN","ROLE_RH")
                        .requestMatchers("/employeList").hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER","ROLE_RH")
                        .requestMatchers("/demandeConge","saveConge").hasAnyAuthority("ROLE_USER")
                .requestMatchers("/webjars/**").permitAll()
                .anyRequest()
                .authenticated())
                .exceptionHandling(
                        exception
                                -> exception.accessDeniedPage(
                                "/accessDenied"))
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/")
                                .permitAll())
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

//    @Bean
//    public UserDetailsService users() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER", "ADMIN")
//                .build();
//        UserDetails employe = User.builder()
//                .username("employe")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails rh = User.builder()
//                .username("rh")
//                .password(passwordEncoder.encode("123"))
//                .roles("RH")
//                .build();
//        UserDetails manager = User.builder()
//                .username("manager")
//                .password(passwordEncoder.encode("123"))
//                .roles("MANAGER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin,employe,rh,manager);
//    }
}
