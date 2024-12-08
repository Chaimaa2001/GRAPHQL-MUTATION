package com.example.graphqlmutation.controller;

import com.example.graphqlmutation.dtos.CentreDTO;
import com.example.graphqlmutation.dtos.EtudiantDTO;
import com.example.graphqlmutation.entities.Centre;
import com.example.graphqlmutation.entities.Etudiant;
import com.example.graphqlmutation.repositories.CentreRepository;
import com.example.graphqlmutation.repositories.EtudiantRepository;
import com.example.graphqlmutation.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class EtudiantController {
    @Autowired
    private CentreRepository centreRepository;
    @Autowired
    private EtudiantService etudiantService;
    @QueryMapping
    public List<Centre>getAllCentres(){

        return centreRepository.findAll();
    }
    @QueryMapping
    public List<Etudiant>listEtudiants(){
        return etudiantService.getStudents();
    }
    @QueryMapping
    public Centre getCentreById(@Argument Long id){
        return centreRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("le centre %s n'existe pas ",id))
        );
    }
    @QueryMapping
    public Etudiant getEtudiantById(@Argument Long id){
        return etudiantService.getEtudiant(id);
    }
    @MutationMapping
    public String deleteEtudiant(@Argument Long id){
        return etudiantService.deleteEtudiant(id);
    }
    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiant){
        return etudiantService.addEtudiant(etudiant);
    }
    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id,@Argument EtudiantDTO etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }
    @SubscriptionMapping
    public Flux<Etudiant> etudiantAdded(){
        return etudiantService.getEtudiantAddedPublisher();
    }
    @MutationMapping
    public String deleteCentre(@Argument Long id){
        if(centreRepository.findById(id).isPresent()){
            centreRepository.deleteById(id);
            return String.format("le centre %s est bien supprimé",id);
        }
        return String.format("l'etudiant %s n'existe pas",id);
    }
    @MutationMapping
    public Centre addCentre(@Argument Centre centre){

        return centreRepository.save(centre);
    }
    @MutationMapping
    public Centre updateCentre(@Argument Long id,@Argument CentreDTO centre){
        Centre centre1=centreRepository.findById(id).orElse(null);
        if(centre1!=null){
            centre1.setNom(centre.nom());
            centre1.setAdresse(centre.adresse());
            centre1.setListEtudiants(centre.etudiantList());
            return centreRepository.save(centre1);
        }
        return null;
    }
}
