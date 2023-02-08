package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.dtos.AuteurDTO;
import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.exceptions.AuthorNotFoundException;
import fr.wf3.alphabetise.exceptions.BookNotFoundException;
import fr.wf3.alphabetise.services.AuteurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin("*")
public class AuteurControllerAPI {
    private AuteurService auteurService;

    @GetMapping("/auteurs")
    public List<AuteurDTO> auteurs() {
        return auteurService.authorsList();
    }

    @GetMapping("/auteurs/{id}")
    public AuteurDTO getAuthorById(@PathVariable(name = "id") Long auteurId) throws AuthorNotFoundException {
        return auteurService.getAuthorById(auteurId);
    }

    @PostMapping("/auteurs")
    public AuteurDTO saveAuthor(@RequestBody AuteurDTO auteurDTO){
        return auteurService.saveAuthor(auteurDTO);
    }

    @PutMapping("/auteurs/{id}")
    public AuteurDTO updateAuthor(@PathVariable Long id, @RequestBody AuteurDTO auteurDTO){
        auteurDTO.setId(id);
        return auteurService.updateAuthor(auteurDTO);
    }

    @DeleteMapping("/auteurs/{id}")
    public void deleteAuthor(@PathVariable Long id){
        auteurService.deleteAuthor(id);
    }


}
