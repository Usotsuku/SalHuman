package com.example.salhumans.security.entities;

import com.example.salhumans.models.Employe;
import com.example.salhumans.security.entities.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@Builder
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)

    private List<Role> roles = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

}