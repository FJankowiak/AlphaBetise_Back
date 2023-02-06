package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Editeur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuteurContentInitialiser {
//    @Autowired
//    private AuteurService auteurService;

    public List<Auteur> contentInitialiser(){
        // Obtenir tout ce qui est déjà en base
        List<Auteur> auteurInBase = new ArrayList<>();
//        List<Auteur> auteurInBase = auteurService.findAllAuteurs();
////        System.err.println(editeurInBase);
//
//        // Future liste de tous les éléments que l'on attend dans la base
//        Set<Auteur> auteursExpected = new HashSet<>();
//
//        // Peupler la liste attendue
//        auteursExpected.add(new Auteur("Magali", "Bonniol"));
//        auteursExpected.add(new Auteur("Pierre", "Bertrand"));
//        auteursExpected.add(new Auteur("", "", "Cathon"));
//        auteursExpected.add(new Auteur("", "", "Cy"));
////        auteursExpected.add(4 = new Auteur("Magali", "Bonniol"));
//        auteursExpected.add(new Auteur("J.C.", "Deveney"));
//        auteursExpected.add(new Auteur("Tania", "Tamarit"));
//        auteursExpected.add(new Auteur("Neil", "Gaiman"));
//        auteursExpected.add(new Auteur("Aurélie", "Neyret"));
//        auteursExpected.add(new Auteur("Ryan T.", "Higgins"));
//        auteursExpected.add(new Auteur("Philippe", "Jalbert"));
//        auteursExpected.add(new Auteur("Christian", "Jolibois"));
//        auteursExpected.add(new Auteur("Christian", "Heinrich"));
//        auteursExpected.add(new Auteur("Loïc", "Jouannigot"));
//        auteursExpected.add(new Auteur("Julien", "Béziat"));
//        auteursExpected.add(new Auteur("Sophie", "Lambda"));
//        auteursExpected.add(new Auteur("Suzanne", "Lang"));
//        auteursExpected.add(new Auteur("Max", "Lang"));
//        auteursExpected.add(new Auteur("", "", "NOB"));
//        auteursExpected.add(new Auteur("Cyril", "Pedrosa"));
//        auteursExpected.add(new Auteur("Roxanne", "Moreil"));
//        auteursExpected.add(new Auteur("Sébastien", "Perez"));
//        auteursExpected.add(new Auteur("Benjamin", "Lacombe"));
//        auteursExpected.add(new Auteur("Rémi", "Simard"));
//        auteursExpected.add(new Auteur("", "", "La Pastèque"));
//        auteursExpected.add(new Auteur("Olivier", "Bocquet"));
//        auteursExpected.add(new Auteur("Jean-Marc", "Rochette"));
//        auteursExpected.add(new Auteur("Jean-François", "Rey"));
//        auteursExpected.add(new Auteur("Fanny", "Hurtrel"));
//        auteursExpected.add(new Auteur("Joanne K.", "Rowling", "J.K. Rowling"));
//        auteursExpected.add(new Auteur("Lolita", "Séchan"));
//        auteursExpected.add(new Auteur("Camille", "Jourdy"));
//        auteursExpected.add(new Auteur("Joann", "Sfar"));
//        auteursExpected.add(new Auteur("Diana", "Wynne Jones"));
//
//
//        // Obtenir juste les noms pour faire un filtrage
//        List<String> names = new ArrayList<>();
//        List<String> firstnames = new ArrayList<>();
//        List<String> pseudo = new ArrayList<>();
//        for(Auteur e : auteurInBase){
//            if(!e.getNom().equals("")){
//                names.add(e.getNom());
//                firstnames.add(e.getPrenom());
//            } else {
//                pseudo.add(e.getPseudonyme());
//            }
//        }
//
//        // Comparer ce qui est en base
//        List<Auteur> missingAuteurByName = auteursExpected.stream().filter(
//                e -> !(names.contains(e.getNom()) && names.contains(e.getNom()))
//        ).collect(Collectors.toList());
//
//        List<Auteur> missingAuteurByPseudo = auteursExpected.stream().filter(
//                e -> !names.contains(e.getPseudonyme())
//        ).collect(Collectors.toList());

//        List<Auteur> missingAuteur = Stream.concat(missingAuteurByName.stream(), missingAuteurByPseudo.stream()).collect(Collectors.toList());

//        System.err.println(missingAuteur.size());
//        System.err.println(missingAuteur);

        // Si des éléments étaient manquant, on les rajoute en base
//        if(missingAuteur.size() > 0){
//            auteurService.addMultipleAuteurs(missingAuteur);
//
//            auteurInBase = auteurService.findAllAuteurs();
//        }
//
//        Map<String, Auteur> map = new HashMap<>();
//
//        for(Auteur auteur : auteurInBase){
//            if(auteur.getNom().equals("")){
//                map.put(auteur.getPseudonyme(), auteur);
//            } else {
//
//            }
//        }


        return auteurInBase;
//        System.err.println(e1);
    }
}
