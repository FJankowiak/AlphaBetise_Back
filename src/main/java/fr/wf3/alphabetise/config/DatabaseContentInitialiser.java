package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.config.databaseContentInitialisers.EditeurContentInitialiser;
import fr.wf3.alphabetise.config.databaseContentInitialisers.ImageContentInitialiser;
import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseContentInitialiser implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EditeurContentInitialiser editeurContentInitialiser;
    @Autowired
    private ImageContentInitialiser imageContentInitialiser;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.err.println("Hello refresh");
//
//        Editeur e1 = new Editeur("Bayard");
//        System.err.println(e1);
        Map<String, Editeur> editeurs = editeurContentInitialiser.contentInitialiser();

        Map<String, Image> images = imageContentInitialiser.contentInitialiser();
        Map<String, Auteur> auteurs;
        Map<String, Image> livres;
//        Map<String, Image> images;
//        Map<String, Image> images;
//        Map<String, Image> images;
//        Map<String, Image> images;

    }
}
