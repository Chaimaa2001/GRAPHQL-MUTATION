package com.example.graphqlmutation;

import com.example.graphqlmutation.entities.Centre;
import com.example.graphqlmutation.entities.Etudiant;
import com.example.graphqlmutation.enums.Genre;
import com.example.graphqlmutation.repositories.CentreRepository;
import com.example.graphqlmutation.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlMutationApplication implements CommandLineRunner {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	CentreRepository centreRepository;
	public static void main(String[] args) {
		SpringApplication.run(GraphqlMutationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Centre centre1=Centre.builder()
				.nom("Maarif").adresse("Biranzarane").build();
		centreRepository.save(centre1);
		Centre centre2=Centre.builder()
				.nom("Oranges").adresse("Oulfa").build();
		centreRepository.save(centre2);
		Etudiant et1=Etudiant.builder()
				.nom("Adnani").prenom("Brahim").genre("Homme")
				.centre(centre1).build();
		etudiantRepository.save(et1);
	}
}
