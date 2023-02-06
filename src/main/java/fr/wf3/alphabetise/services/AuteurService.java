package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.repositories.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService implements IAuteurService{
    @Autowired
    private AuteurRepository auteurRepository;

    @Override
    public Auteur addAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public Auteur updateAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public Optional<Auteur> findAuteurById(Long id) {
        return auteurRepository.findAuteurById(id);
    }

    @Override
    public List<Auteur> findAllAuteur() {
        return auteurRepository.findAll();
    }

    @Override
    public void deleteAuteur(Long id) {
        Optional<Auteur> auteur = auteurRepository.findById(id);
        if (auteur.isPresent()) {
            auteurRepository.delete(auteur.get());
        }
    }
}
