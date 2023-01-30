package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.Evenement;
import fr.wf3.alphabetise.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    public List<Evenement> findByLivreCodeEAN(Long codeEAN);

    @Query("select e from Evenement e where e.date <= :currentDate")
    public List<Evenement> findAllByDateAfter(@Param("currentDate") LocalDateTime currentDate);

    public void deleteById(long id);

}
