package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.services.LivreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/livres")
@RestController
public class LivreControllerAPI {
    private LivreService livreService;

    public LivreControllerAPI(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/books")
    List<LivreDTO> findAllLivres(){
        return this.livreService.booksList();
    }
}
