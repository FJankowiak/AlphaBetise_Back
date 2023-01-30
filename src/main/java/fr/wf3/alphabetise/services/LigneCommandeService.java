package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.entities.LigneCommande;
import fr.wf3.alphabetise.repositories.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public LigneCommande addLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepository.save(ligneCommande);
    }

    public LigneCommande updateLigneCommande(LigneCommande ligneCommande){return ligneCommandeRepository.save(ligneCommande);}

    public List<LigneCommande> getAllLignesCommande(){
        return ligneCommandeRepository.findAll();
    }

    public void deleteLigneCommande(LigneCommande ligneCommande){

    }


}
