package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Editeur;

import java.util.List;
import java.util.Optional;

public interface IEditeurService {
    public Editeur addEditeur(Editeur editeur);
    public Editeur updateEditeur(Editeur editeur);
    public Optional<Editeur> findEditeurById(Long id);
    public List<Editeur> findAllEditeur();
    public void deleteEditeur(Long id);
    public List<Editeur> addMultipleEditeurs(List<Editeur> editeurs);
}
