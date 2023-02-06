package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.services.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EditeurContentInitialiser {
    @Autowired
    private EditeurService editeurService;

    public Map<String, Editeur> contentInitialiser(){
        // Obtenir tout ce qui est déjà en base
        List<Editeur> editeurInBase = editeurService.findAllEditeur();
//        System.err.println(editeurInBase);

        // Future liste de tous les éléments que l'on attend dans la base
        List<Editeur> editeursExpected = new ArrayList<>();

        // Peupler la liste attendue
//        Editeur e1 = new Editeur("Bayard");
        editeursExpected.add(new Editeur("Actes Sud BD"));
        editeursExpected.add(new Editeur("Aire Libre"));
        editeursExpected.add(new Editeur("Albin Michel"));
        editeursExpected.add(new Editeur("Balivernes Éditions"));
        editeursExpected.add(new Editeur("Albin Michel Jeunesse"));
        editeursExpected.add(new Editeur("BD Kids"));
        editeursExpected.add(new Editeur("Casterman"));
        editeursExpected.add(new Editeur("Delcourt"));
        editeursExpected.add(new Editeur("Deux Coqs d'Or"));
        editeursExpected.add(new Editeur("Editions Delcourt"));
        editeursExpected.add(new Editeur("Gallimard Jeunesse"));
        editeursExpected.add(new Editeur("Glénat"));
        editeursExpected.add(new Editeur("JSP"));
        editeursExpected.add(new Editeur("Les Albums Casterman"));
        editeursExpected.add(new Editeur("Margot"));
        editeursExpected.add(new Editeur("Mini BD KIDS"));
        editeursExpected.add(new Editeur("Pastel"));
        editeursExpected.add(new Editeur("PKJ"));
        editeursExpected.add(new Editeur("Romans Ynnis"));

//        editeursExpected.add();

        // Obtenir juste les noms pour faire un filtrage
        List<String> names = new ArrayList<>();
        for(Editeur e : editeurInBase){
            names.add(e.getNom());
        }
//        System.err.println(names);
//        System.err.println(names.size());

        // Comparer ce qui est en base
        List<Editeur> missingEditeur = editeursExpected.stream().filter(
                e -> !names.contains(e.getNom())
        ).collect(Collectors.toList());

//        System.err.println(missingEditeur.size());
//        System.err.println(missingEditeur);

        // Si des éléments étaient manquant, on les rajoute en base
        if(missingEditeur.size() > 0){
            editeurService.addMultipleEditeurs(missingEditeur);

            editeurInBase = editeurService.findAllEditeur();
        }

        Map<String, Editeur> map = new HashMap<>();

        for(Editeur e : editeurInBase){
            map.put(e.getNom(), e);
        }

        return map;
//        System.err.println(e1);
    }
}
