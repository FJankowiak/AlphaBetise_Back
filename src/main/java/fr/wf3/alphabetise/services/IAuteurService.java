package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Auteur;

import java.util.List;
import java.util.Optional;

public interface IAuteurService {

        public Auteur addAuteur(Auteur auteur);
        public Auteur updateAuteur(Auteur auteur);
        public Optional<Auteur> findAuteurById(Long id);
        public List<Auteur> findAllAuteur();
        public void deleteAuteur(Long id);

}
