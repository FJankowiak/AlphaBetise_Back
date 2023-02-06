package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.config.databaseContentInitialisers.EditeurContentInitialiser;
import fr.wf3.alphabetise.config.databaseContentInitialisers.ImageContentInitialiser;
import fr.wf3.alphabetise.config.databaseContentInitialisers.UserContentInitialiser;
import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.entities.User;
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

    @Autowired
    private UserContentInitialiser userContentInitialiser;


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
        System.err.println("avant le user content initialiser");
        Map<String, User> users = userContentInitialiser.contentInitialiser();
//        Map<String, Image> images;
//        Map<String, Image> images;
//        Map<String, Image> images;
//        Map<String, Image> images;

    }
}
