package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.exceptions.EmptyFieldException;
import fr.wf3.alphabetise.exceptions.MissingEntityById;
import fr.wf3.alphabetise.repositories.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuteurService implements IAuteurService {
    @Autowired
    private AuteurRepository auteurRepository;

    public Auteur addAuteur(Auteur auteur){
        System.err.println("dans le addAuteur");
        if(auteur.fullEntity()){
            return auteurRepository.save(auteur);
        } else {
            throw new EmptyFieldException("auteur");
        }
    }

    public Auteur updateAuteur(Auteur auteur){
        if(auteur.fullEntity()){
            return auteurRepository.save(auteur);
        } else {
            throw new EmptyFieldException("auteur");
        }
    }

    public Auteur findAuteurById(Long id){

        return auteurRepository.findById(id).orElseThrow(() -> new MissingEntityById("Auteur", id));
    }

    @Override
    public List<Auteur> findAllAuteurs() {
        return auteurRepository.findAll();
    }

    public List<Auteur> findAllAuteur(){
        return auteurRepository.findAll();
    }

    public void deleteAuteur(Long id){
        auteurRepository.deleteById(id);
    }

    public List<Auteur> addMultipleAuteurs(List<Auteur> auteurs){
        List<Auteur> toBeAdded = auteurs.stream().filter(
                e -> e.fullEntity()
        ).collect(Collectors.toList());

        List<Auteur> notAdded = auteurs.stream().filter(
                e -> !e.fullEntity()
        ).collect(Collectors.toList());

        for(Auteur e : notAdded){
            System.err.println(String.format("Auteur non ajouté à cause de champs obligatoires vides : %s", e.toString()));
        }

        return auteurRepository.saveAll(toBeAdded);
    }


}
