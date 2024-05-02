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
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long congeId;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private String statuts;
    @ManyToOne
    private Employe employe;


}
