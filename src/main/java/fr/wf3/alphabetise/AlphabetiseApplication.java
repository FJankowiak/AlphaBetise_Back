package fr.wf3.alphabetise;

import fr.wf3.alphabetise.dtos.AuteurDTO;
import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.exceptions.AuthorNotFoundException;
import fr.wf3.alphabetise.services.AuteurService;
import fr.wf3.alphabetise.services.LivreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AlphabetiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphabetiseApplication.class, args);
	}

	//Creation d'un objet CommandLineRunner pour tester l'application
//	@Bean
//	CommandLineRunner commandLineRunner(AuteurService auteurService, LivreService livreService) {
//		//Retourne une expression lamda qui va s'executer au demmarage grace à l'annotation @Bean
//		return args -> {
//			//Ajout des auteurs et livres
//			Stream.of("FABIEN","ANDY","CHRISTINE").forEach(nomAuteur->{
//				AuteurDTO auteur = new AuteurDTO();
//				auteur.setId(id);
//				auteur.setNom("nom");
//				auteur.setPrenom("prenom");
//				auteurService.saveAuthor(auteur);
//			});
//			auteurService.authorsList().forEach(auteur->{
//				try{
//					livreService.booksList();
//
//				} catch(AuthorNotFoundException e) {
//					e.printStackTrace();
//				}
//
//			});
//		};
//
//	}

}
