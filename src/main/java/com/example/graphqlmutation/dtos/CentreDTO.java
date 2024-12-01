package com.example.graphqlmutation.dtos;

import com.example.graphqlmutation.entities.Etudiant;

import java.util.List;

public record CentreDTO(
        String nom,
        String adresse,
        List<Etudiant> etudiantList
) {
}
