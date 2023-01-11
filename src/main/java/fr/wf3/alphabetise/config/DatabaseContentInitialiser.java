package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.config.databaseContentInitialisers.EditeurContentInitialiser;
import fr.wf3.alphabetise.entities.Editeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class DatabaseContentInitialiser implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EditeurContentInitialiser editeurContentInitialiser;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.err.println("Hello refresh");
//
//        Editeur e1 = new Editeur("Bayard");
//        System.err.println(e1);
        editeurContentInitialiser.contentInitialiser();
    }
}
