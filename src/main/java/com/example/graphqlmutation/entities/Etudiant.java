package com.example.graphqlmutation.entities;

import com.example.graphqlmutation.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder @Table(name = "etudiants")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="nom_etudiant",nullable = false)
    String nom;
    @Column(name="prenom_etudiant")
    String prenom;
    //@Enumerated(EnumType.STRING)
    String genre;
    @ManyToOne
    @NotNull
    @JoinColumn(name="centre_id")
    Centre centre;
}
