package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.services.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuteurContentInitialiser {
    @Autowired
    private AuteurService auteurService;

    public Map<String, Auteur> contentInitialiser(){
        // Obtenir tout ce qui est déjà en base
//        List<Auteur> auteurInBase = new ArrayList<>();
        List<Auteur> auteurInBase = auteurService.findAllAuteurs();
//        System.err.println(editeurInBase);
        Map<String, Auteur> mapInBase = mapFromList(auteurInBase);

        // Future liste de tous les éléments que l'on attend dans la base
        List<Auteur> auteursExpected = new ArrayList<>();

        // Peupler la liste attendue
        auteursExpected.add(new Auteur("Magali", "Bonniol"));
        auteursExpected.add(new Auteur("Pierre", "Bertrand"));
        auteursExpected.add(new Auteur("", "", "Cathon"));
        auteursExpected.add(new Auteur("", "", "Cy"));
//        auteursExpected.add(4 = new Auteur("Magali", "Bonniol"));
        auteursExpected.add(new Auteur("J.C.", "Deveney"));
        auteursExpected.add(new Auteur("Tania", "Tamarit"));
        auteursExpected.add(new Auteur("Stéphanie", "Dunand-Pallaz"));
        auteursExpected.add(new Auteur("Sophie", "Turrel"));
        auteursExpected.add(new Auteur("Neil", "Gaiman"));
        auteursExpected.add(new Auteur("Aurélie", "Neyret"));
        auteursExpected.add(new Auteur("Ryan T.", "Higgins"));
        auteursExpected.add(new Auteur("Philippe", "Jalbert"));
        auteursExpected.add(new Auteur("Christian", "Jolibois"));
        auteursExpected.add(new Auteur("Christian", "Heinrich"));
        auteursExpected.add(new Auteur("Loïc", "Jouannigot"));
        auteursExpected.add(new Auteur("Julien", "Béziat"));
        auteursExpected.add(new Auteur("Sophie", "Lambda"));
        auteursExpected.add(new Auteur("Suzanne", "Lang"));
        auteursExpected.add(new Auteur("Max", "Lang"));
        auteursExpected.add(new Auteur("", "", "NOB"));
        auteursExpected.add(new Auteur("Cyril", "Pedrosa"));
        auteursExpected.add(new Auteur("Roxanne", "Moreil"));
        auteursExpected.add(new Auteur("Sébastien", "Perez"));
        auteursExpected.add(new Auteur("Benjamin", "Lacombe"));
        auteursExpected.add(new Auteur("Rémi", "Simard"));
        auteursExpected.add(new Auteur("", "", "La Pastèque"));
        auteursExpected.add(new Auteur("Olivier", "Bocquet"));
        auteursExpected.add(new Auteur("Jean-Marc", "Rochette"));
        auteursExpected.add(new Auteur("Jean-François", "Rey"));
        auteursExpected.add(new Auteur("Fanny", "Hurtrel"));
        auteursExpected.add(new Auteur("Joanne K.", "Rowling", "J.K. Rowling"));
        auteursExpected.add(new Auteur("Lolita", "Séchan"));
        auteursExpected.add(new Auteur("Camille", "Jourdy"));
        auteursExpected.add(new Auteur("Joann", "Sfar"));
        auteursExpected.add(new Auteur("Diana", "Wynne Jones"));

        Map<String, Auteur> mapExpected = mapFromList(auteursExpected);
        System.err.println("Size auteur expected : " + auteursExpected.size());

        System.err.println(auteursExpected);
        System.err.println(mapExpected);

        // Obtenir juste les noms pour faire un filtrage
        Set<String> names_in_base = mapInBase.keySet();
        Set<String> names_expected = mapExpected.keySet();

        System.err.println(names_in_base);
        System.err.println(names_expected);

        Set<String> comparison = names_expected.stream().filter(
                s -> !names_in_base.contains(s)
        ).collect(Collectors.toSet());


//
//
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
////        // Comparer ce qui est en base
//        List<Auteur> missingAuteurByName = auteursExpected.stream().filter(
//                e -> !(names.contains(e.getNom()) && names.contains(e.getNom()))
//        ).collect(Collectors.toList());
//
//        List<Auteur> missingAuteurByPseudo = auteursExpected.stream().filter(
//                e -> !names.contains(e.getPseudonyme())
//        ).collect(Collectors.toList());
//
//        List<Auteur> missingAuteur = Stream.concat(missingAuteurByName.stream(), missingAuteurByPseudo.stream()).collect(Collectors.toList());

//        System.err.println(missingAuteur.size());
//        System.err.println(missingAuteur);

        // Si des éléments étaient manquant, on les rajoute en base
        System.err.println("Comparaison : " + comparison.size() + " élément(s) manquant(s)");

        if(comparison.size() > 0){
            List<Auteur> auteursToAdd = new ArrayList<>();
            for(String name : comparison){
                auteursToAdd.add(mapExpected.get(name));
            }

            auteurService.addMultipleAuteurs(auteursToAdd);

            auteurInBase = auteurService.findAllAuteurs();
        }

        Map<String, Auteur> map = mapFromList(auteurInBase);

//        for(Auteur auteur : auteurInBase){
//            if(auteur.getNom().equals("")){
//                map.put(auteur.getPseudonyme(), auteur);
//            } else {
//                if(map.keySet().contains(auteur.getNom())){
//                    map.put(auteur.getNom() + " " + auteur.getPrenom(), auteur);
//                } else {
//                    map.put(auteur.getNom(), auteur);
//                }
//            }
//        }

        System.err.println(map.keySet());
        System.err.println(map.size());


        return map;
//        System.err.println(e1);
    }



    private Map<String, Auteur> mapFromList(List<Auteur> auteurs){
        System.err.println("mapFromList");
//        System.err.println(auteurs);
        Map<String, Auteur> map = new HashMap<>();

        for(Auteur auteur : auteurs){
//            System.err.println(auteur);
            if(auteur.getNom().equals("")){
                map.put(auteur.getPseudonyme(), auteur);
//                System.err.println(auteur.getPseudonyme());
            } else {
                if(map.keySet().contains(auteur.getNom())){
                    map.put(auteur.getNom() + " " + auteur.getPrenom(), auteur);
//                    System.err.println(auteur.getNom() + " " + auteur.getPrenom());
                } else {
                    map.put(auteur.getNom(), auteur);
//                    System.err.println(auteur.getNom());

                }
            }
        }

        System.err.println("map size output :" + map.size());

        return map;
    }
}
