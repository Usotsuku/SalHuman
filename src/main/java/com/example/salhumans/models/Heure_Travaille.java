package com.example.salhumans.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Heure_Travaille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long HeureId;
    private Date date;
    private String type;
    private int nb_heures;
    @ManyToOne
    private Employe employe;
}
//hello
