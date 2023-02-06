package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.services.AuteurService;
import fr.wf3.alphabetise.services.IAuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/auteurs")
@RestController
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @GetMapping
    public ResponseEntity<List<Auteur>> getAllAuteurs() {
        return new ResponseEntity<List <Auteur>>( auteurService.findAllAuteur(), HttpStatus.OK);
    }
    // Ajouter un auteur
    @GetMapping("/auteur")
    public String auteur(Model model) {
        model.addAttribute("auteur", new Auteur());
        return "auteur";
    }
}
