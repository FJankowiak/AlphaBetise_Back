package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Adresse;
import fr.wf3.alphabetise.entities.Editeur;

import java.util.List;

public interface IAdresseService {
    public Adresse addAdresse(Adresse adresse);
    public Adresse updateAdresse(Adresse adresse);
    public Adresse findAdresseById(Long id);
    public List<Adresse> findAllAdresse();
    public void deleteAdresse(Long id);
    public List<Adresse> addMultipleAdresses(List<Adresse> adresses);
}
