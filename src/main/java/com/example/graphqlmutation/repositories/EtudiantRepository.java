package com.example.graphqlmutation.repositories;

import com.example.graphqlmutation.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
