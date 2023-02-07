package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.services.AuteurService;
import fr.wf3.alphabetise.services.IAuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/auteurs")
@RestController
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @GetMapping
    public ResponseEntity<List<Auteur>> findAll() {
        return new ResponseEntity<List <Auteur>>( auteurService.findAllAuteur(), HttpStatus.OK);
    }

    @GetMapping("/auteurs/{id}")
    public ResponseEntity<Auteur> findAuteurById(@PathVariable Long id) {
        Optional<Auteur> auteurData = auteurService.findAuteurById(id);
        if  (auteurData.isPresent()){
            return new ResponseEntity<>(auteurData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/auteurs")
    public ResponseEntity<Object> addAuteur(@RequestBody Auteur auteur) {
       try {
           Auteur _auteur = auteurService.addAuteur(new Auteur (auteur.getPrenom(), auteur.getNom(),auteur.getPseudonyme(), auteur.getDateNaissance() ));
           return new ResponseEntity<>(_auteur, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/auteurs/{id}")
    public ResponseEntity<Auteur> updateAuteur(@PathVariable("id") Long id, @RequestBody Auteur auteur) {
        Optional<Auteur> auteurData = auteurService.findAuteurById(id);
        if (auteurData.isPresent()) {
            Auteur _auteur = auteurData.get();
            _auteur.setPrenom(auteur.getPrenom());
            _auteur.setNom(auteur.getNom());
            _auteur.setPseudonyme(auteur.getPseudonyme());
            _auteur.setDateNaissance(auteur.getDateNaissance());
            return new ResponseEntity<>(auteurService.updateAuteur(_auteur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/auteurs/{id}")
    public ResponseEntity<HttpStatus> deleteAuteur(@PathVariable("id") Long id) {
        Optional<Auteur> auteur = auteurService.findAuteurById(id);
        if (auteur.isPresent()) {
            auteurService.deleteAuteur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
