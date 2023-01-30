package fr.wf3.alphabetise.repositories;


import fr.wf3.alphabetise.entities.LigneCommande;
import fr.wf3.alphabetise.embeddedClasses.LigneCommandePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {
    public List<LigneCommande> findByCommandeId(long id);

    public List<LigneCommande> findByLivreCodeEAN(Long codeEAN);

    public LigneCommande findByCommandeIdAndLivreCodeEAN(long id, Long codeEAN);

}
