package com.example.graphqlmutation.mapper;

import com.example.graphqlmutation.dtos.EtudiantDTO;
import com.example.graphqlmutation.entities.Centre;
import com.example.graphqlmutation.entities.Etudiant;
import com.example.graphqlmutation.repositories.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEtudiant {
    @Autowired
    CentreRepository centreRepository;
    public void toEtudiant(Etudiant et, EtudiantDTO dto)
    {
        Centre centre=centreRepository.findById(dto.centreId()).orElse(null);
        if(dto!=null){
            et.setNom(dto.nom());
            et.setPrenom(dto.prenom());
            et.setGenre(dto.genre());
            et.setCentre(centre);
        }
    }

}
