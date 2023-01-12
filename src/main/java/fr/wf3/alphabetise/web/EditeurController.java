package fr.wf3.alphabetise.web;

//import org.springframework.stereotype.Controller;
import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.services.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/editeur")
public class EditeurController {
    @Autowired
    private EditeurService editeurService;

    @GetMapping
    public ResponseEntity<List<Editeur>> getAllEditeurs(){
        return new ResponseEntity<>(editeurService.findAllEditeur(), HttpStatus.OK);
    }
}
