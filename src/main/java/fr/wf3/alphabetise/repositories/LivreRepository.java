package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    LivreDTO findByCodeEAN(Long codeEAN);
}
