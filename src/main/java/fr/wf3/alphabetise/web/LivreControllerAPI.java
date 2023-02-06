package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.services.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livres")
@AllArgsConstructor
//@CrossOrigin("*")
public class LivreControllerAPI {
    private LivreService livreService;


    @GetMapping//("/Livres")
    public List<LivreDTO> books(){
        return livreService.booksList();
    }
}
