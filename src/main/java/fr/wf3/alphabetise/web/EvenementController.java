package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.entities.Evenement;
import fr.wf3.alphabetise.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Evenement>> findAll(){
        List<Evenement> evenements = evenementService.findAllEvenements();

        return new ResponseEntity<>(evenements, HttpStatus.OK);
    }
}
