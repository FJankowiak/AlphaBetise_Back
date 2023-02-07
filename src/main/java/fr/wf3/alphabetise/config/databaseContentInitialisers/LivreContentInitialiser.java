package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LivreContentInitialiser {
    @Autowired
    private LivreService livreService;

    private Map<String, Auteur> auteurs;
    private Map<String, Image> images;

    public Map<Long, Livre> contentInitialiser(Map<String, Auteur> auteurs_in, Map<String, Image> images_in){
        auteurs = auteurs_in;
        images = images_in;
        System.err.println(images.keySet());

        // Obtenir tout ce qui est déjà en base
        List<Livre> livreInBase = livreService.findAllLivres();

        // Future liste de tous les éléments que l'on attend dans la base
        List<Livre> livresExpected = new ArrayList<>();

        // Peupler la liste attendue
//        livresExpected.add(new Livre("Magali", "Bonniol"));
//        livresExpected.add(new Livre("Pierre", "Bertrand"));
//        livresExpected.add(new Livre("", "", "Cathon"));
//        livresExpected.add(new Livre("", "", "Cy"));
////        livresExpected.add(4 = new Livre("Magali", "Bonniol"));
//        livresExpected.add(new Livre("J.C.", "Deveney"));
//        livresExpected.add(new Livre("Tania", "Tamarit"));
//        livresExpected.add(new Livre("Neil", "Gaiman"));
//        livresExpected.add(new Livre("Aurélie", "Neyret"));
//        livresExpected.add(new Livre("Ryan T.", "Higgins"));
//        livresExpected.add(new Livre("Philippe", "Jalbert"));
//        livresExpected.add(new Livre("Christian", "Jolibois"));
//        livresExpected.add(new Livre("Christian", "Heinrich"));
//        livresExpected.add(new Livre("Loïc", "Jouannigot"));
//        livresExpected.add(new Livre("Julien", "Béziat"));
//        livresExpected.add(new Livre("Sophie", "Lambda"));
//        livresExpected.add(new Livre("Suzanne", "Lang"));
//        livresExpected.add(new Livre("Max", "Lang"));
//        livresExpected.add(new Livre("", "", "NOB"));
//        livresExpected.add(new Livre("Cyril", "Pedrosa"));
//        livresExpected.add(new Livre("Roxanne", "Moreil"));
//        livresExpected.add(new Livre("Sébastien", "Perez"));
//        livresExpected.add(new Livre("Benjamin", "Lacombe"));
//        livresExpected.add(new Livre("Rémi", "Simard"));
//        livresExpected.add(new Livre("", "", "La Pastèque"));
//        livresExpected.add(new Livre("Olivier", "Bocquet"));
//        livresExpected.add(new Livre("Jean-Marc", "Rochette"));
//        livresExpected.add(new Livre("Jean-François", "Rey"));
//        livresExpected.add(new Livre("Fanny", "Hurtrel"));
//        livresExpected.add(new Livre("Joanne K.", "Rowling", "J.K. Rowling"));
//        livresExpected.add(new Livre("Lolita", "Séchan"));
//        livresExpected.add(new Livre("Camille", "Jourdy"));
//        livresExpected.add(new Livre("Joann", "Sfar"));
//        livresExpected.add(new Livre("Diana", "Wynne Jones"));

//        Map<Long, Livre> mapExpected = mapFromList(livresExpected);
        System.err.println("Size livre expected : " + livresExpected.size());

        System.err.println(livresExpected);
//        System.err.println(mapExpected);

        List<Long> names = livresExpected.stream().map(c -> c.getCodeEAN()).collect(Collectors.toList());


        // Comparer ce qui est en base
        List<Livre> comparison = livresExpected.stream().filter(
                e -> !(names.contains(e.getCodeEAN()))
        ).collect(Collectors.toList());

        // Si des éléments étaient manquant, on les rajoute en base
        System.err.println("Comparaison : " + comparison.size() + " élément(s) manquant(s)");

        if(comparison.size() > 0){
            livreService.addMultipleLivres(comparison);

            livreInBase = livreService.findAllLivres();
        }

        Map<Long, Livre> map = mapFromList(livreInBase);

        System.err.println(map.keySet());
        System.err.println(map.size());


        return map;
//        System.err.println(e1);
    }


//    private Livre creerLivre(String auteur, String image){
//
//    }



    private Map<Long, Livre> mapFromList(List<Livre> livres){
        System.err.println("mapFromList");
//        System.err.println(livres);
        Map<Long, Livre> map = new HashMap<>();

        for(Livre livre : livres){
//            System.err.println(livre);
            map.put(livre.getCodeEAN(), livre);
        }

        System.err.println("map size output :" + map.size());

        return map;
    }
}
