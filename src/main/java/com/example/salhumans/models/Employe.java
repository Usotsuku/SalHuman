package com.example.salhumans.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employe extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeId;
    private String nom;
    private String prenom;
    private String departement;
    private String poste;
    private Date date_embauche;
    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    private List<Conge> conges = new ArrayList<>();
    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    private List<Fiche_Paie> Fiches = new ArrayList<>();
    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    private List<Heure_Travaille> Heures_Travailles = new ArrayList<>();

}
