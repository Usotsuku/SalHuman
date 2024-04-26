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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    private MyUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/createEmploye","/saveEmploye").hasAnyAuthority("ROLE_ADMIN","ROLE_RH")
                        .requestMatchers("/showEmploye","/updateEmploye","/deleteEmploye").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers("/employeList").hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER","ROLE_RH")
                .requestMatchers("/webjars/**").permitAll()
                .anyRequest()
                .authenticated())
                .exceptionHandling(
                        exception
                                -> exception.accessDeniedPage(
                                "/accessDenied"))
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/webjars/**")
//                        .permitAll())
                .formLogin(form -> form
                        .loginPage("/login").defaultSuccessUrl("/")
                        .permitAll()
                )


//                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }


    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("123"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "ADMIN")
                .build();
        UserDetails employe = User.builder()
                .username("employe")
                .password(passwordEncoder.encode("123"))
                .roles("USER")
                .build();
        UserDetails rh = User.builder()
                .username("rh")
                .password(passwordEncoder.encode("123"))
                .roles("RH")
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("123"))
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user, admin,employe,rh,manager);
    }
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        return new InMemoryUserDetailsManager(
//                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
//                User.withUsername("employee").password(passwordEncoder.encode("123")).roles("USER").build(),
//                User.withUsername("rh").password(passwordEncoder.encode("123")).roles("RH").build(),
//                User.withUsername("manager").password(passwordEncoder.encode("123")).roles("MANAGER").build()
//        );
//    }
}
