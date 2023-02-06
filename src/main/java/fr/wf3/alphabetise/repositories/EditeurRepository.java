package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EditeurRepository extends JpaRepository<Editeur, Long> {
    void deleteEditeurById(Long id);

    Optional<Editeur> findEditeurById(Long id);
}
