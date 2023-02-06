package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    void deleteById(Long id);

    Optional<Auteur> findAuteurById(Long id);

}