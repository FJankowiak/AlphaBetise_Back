package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

}
