package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.services.LivreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/livres")
@RestController
public class LivreControllerAPI {
    private LivreService livreService;

    public LivreControllerAPI(LivreService livreService) {
        this.livreService = livreService;

    }
}
