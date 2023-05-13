package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.services.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livres")
@AllArgsConstructor
//@CrossOrigin("*")
public class LivreControllerAPI {
    private LivreService livreService;


    @GetMapping("/books-list")
    public List<LivreDTO> books(){
        return livreService.booksList();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Object> findLivreById(@PathVariable Long id) {
        LivreDTO livre = livreService.getBookById(id);
        if(livre != null){
            return new ResponseEntity<>(livre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pas de livre avec l'ISBN " + id, HttpStatus.NOT_FOUND);
        }
    }

}
