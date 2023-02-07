package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.*;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.enums.Categorie;
import fr.wf3.alphabetise.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LivreContentInitialiser {
    @Autowired
    private LivreService livreService;

    private Map<String, Auteur> auteurs;
    private Map<String, Image> images;
    private Map<String, Editeur> editeurs;

    public Map<Long, Livre> contentInitialiser(Map<String, Auteur> auteurs_in, Map<String, Image> images_in, Map<String, Editeur> editeurs_in){
        auteurs = auteurs_in;
        images = images_in;
        editeurs = editeurs_in;

        System.err.println(images.keySet());
        System.err.println(auteurs.keySet());
        System.err.println(editeurs.keySet());

        // Obtenir tout ce qui est déjà en base
        List<Livre> livreInBase = livreService.findAllLivres();

        // Future liste de tous les éléments que l'on attend dans la base
        List<Livre> livresExpected = new ArrayList<>();

        // Peupler la liste attendue
        String[] temp = {"Perez", "Lacombe"};
        List<String> auteurs_names = new ArrayList<>(Arrays.asList(temp));

        livresExpected.add(creerLivre("L'ETONNANTE FAMILLE APPENZELL", 9791095184249l,
                "Ma grand-mère se nommait Eugénie. Eugénie Appenzell. D'elle, je tiens mes longs cheveux bouclés et, dit-on, mon caractère bien trempé. Peu de jours avant ma naissance, grand-mère Eugénie quitta les siens. En héritage, elle me laissa une boîte remplie de photographies et de lettres. \"Pour que tu connaisses ta famille\", m'avait-elle écrit. Durant des années, j'ai démêlé les liens et les intrigues qui unissent ces personnes extraordinaires.\n" +
                        "J'ai pleuré et j'ai ri... Aujourd'hui, je vous livre leur histoire. Mon histoire. Celle de l'étonnante famille Appenzell.",
                19.90f, Categorie.BEBES, "", auteurs_names, "etonnanteFamilleAppenzel.jfif", "Margot"
        ));
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

        List<Long> names = livreInBase.stream().map(c -> c.getCodeEAN()).collect(Collectors.toList());


        // Comparer ce qui est en base
        List<Livre> comparison = livresExpected.stream().filter(
                e -> !names.contains(e.getCodeEAN())
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


    private Livre creerLivre(String titre, long codeEan, String resume, float prix, Categorie categorie, String collection, List<String> auteurs, String image, String editeur_name){
        Livre livre;
        List<Auteur> auteurs1 = getFromMap(auteurs);
        List<Image> images1 = getImageFromMap(image);
        Editeur editeur = editeurs.get(editeur_name);
        livre = new Livre(codeEan, titre, resume, collection, categorie, new Date(), 10, prix, editeur, auteurs1, images1);

        return livre;

    }

    private List<Auteur> getFromMap(List<String> noms){
        List<Auteur> auteurs_out = new ArrayList<>();

        for (String nom : noms){
            auteurs_out.add(auteurs.get(nom));
        }

        return auteurs_out;
    }

    private List<Image> getImageFromMap(String nom){
        List<Image> image_out = new ArrayList<>();
        image_out.add(images.get(nom));

        return image_out;
    }



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
