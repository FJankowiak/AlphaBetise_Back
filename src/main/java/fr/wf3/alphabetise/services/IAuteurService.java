package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Auteur;

import java.util.List;

public interface IAuteurService {
    public Auteur addAuteur(Auteur auteur);
    public Auteur updateAuteur(Auteur auteur);
    public Auteur findAuteurById(Long id);
    public List<Auteur> findAllAuteurs();
    public void deleteAuteur(Long id);
    public List<Auteur> addMultipleAuteurs(List<Auteur> auteurs);
}
