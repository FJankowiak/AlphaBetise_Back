package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Evenement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IEvenementService {
    public List<Evenement> findAllEvenements();
    public List<Evenement> findAllAfterCurrentDate();

    public Optional<Evenement> findById(long id);

    public Evenement addEvenement(Evenement evenement);

    public Evenement updateEvenement(Evenement evenement);

    public void deleteEvenement(Evenement evenement);
}
