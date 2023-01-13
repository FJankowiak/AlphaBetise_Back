package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.services.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditeurContentInitialiser {
    @Autowired
    private EditeurService editeurService;

    public void contentInitialiser(){
        List<Editeur> editeurInBase = editeurService.findAllEditeur();
        System.err.println(editeurInBase);

        List<Editeur> editeursExpected = new ArrayList<>();

        Editeur e1 = new Editeur("Bayard");

        editeursExpected.add(e1);

        List<String> names = new ArrayList<>();
        for(Editeur e : editeurInBase){
            names.add(e.getNom());
        }
        System.err.println(names);
        System.err.println(names.size());

        List<Editeur> missingEditeur = editeursExpected.stream().filter(
                e -> !names.contains(e.getNom())
        ).collect(Collectors.toList());

        System.err.println(missingEditeur.size());
        System.err.println(missingEditeur);

        if(missingEditeur.size() > 0){
            editeurService.addMultipleEditeurs(missingEditeur);
        }

        System.err.println(e1);



    }
}
