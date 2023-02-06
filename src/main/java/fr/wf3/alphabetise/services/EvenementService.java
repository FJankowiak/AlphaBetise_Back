package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Evenement;
import fr.wf3.alphabetise.repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EvenementService implements IEvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> findAllEvenements(){
        return evenementRepository.findAll();
    }

    public List<Evenement> findAllAfterCurrentDate(){
        LocalDateTime current = LocalDateTime.now();

        return evenementRepository.findAllByDateAfter(current);
    }

    public Optional<Evenement> findById(long id){
        return evenementRepository.findById(id);
    }

    public Evenement addEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    public Evenement updateEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    public void deleteEvenement(Evenement evenement){
        evenementRepository.deleteById(evenement.getId());
    }
}
