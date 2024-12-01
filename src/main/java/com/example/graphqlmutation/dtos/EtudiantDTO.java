package com.example.graphqlmutation.dtos;

import com.example.graphqlmutation.enums.Genre;

public record EtudiantDTO(
        String nom,
        String prenom,
        String genre,
        Long centreId
) {
}
