package fr.wf3.alphabetise.repositories;


import fr.wf3.alphabetise.entities.LigneCommande;
import fr.wf3.alphabetise.entities.LigneCommandeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeId> {
    public List<LigneCommande> findByCommandeId(long id);

    public List<LigneCommande> findByLivreCodeEAN(String codeEAN);

    public LigneCommande findByCommandeIdAndLivreCodeEAN(long id, String codeEAN);

}
