package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.exceptions.BookNotFoundException;
import fr.wf3.alphabetise.services.LivreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
//@CrossOrigin("*")
public class LivreControllerAPI {
    private LivreService livreService;


    @GetMapping("/Livres")
    public List<LivreDTO> books(){
        return livreService.booksList();
    }

    @GetMapping("/livres/{id}")
    public LivreDTO getBookById(@PathVariable(name = "id") Long codeEAN) throws BookNotFoundException {
        return livreService.getBookById(codeEAN);
    }

    @PostMapping("/livres")
    public LivreDTO addNewBook(@RequestBody LivreDTO livreDTO){
        return livreService.addNewBook(livreDTO);
    }

    @PutMapping("/livres/{codeEAN}")
    public LivreDTO updateBook(@PathVariable Long codeEAN, @RequestBody LivreDTO livreDTO){
        livreDTO.setCodeEAN(codeEAN);
        return livreService.updateBook(livreDTO);
    }

    @DeleteMapping("/livres/{id}")
    public void deleteBook(@PathVariable Long id){
        livreService.deleteBook(id);
    }
}
