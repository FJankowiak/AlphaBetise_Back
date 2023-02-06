package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Adresse;
import fr.wf3.alphabetise.exceptions.EmptyFieldException;
import fr.wf3.alphabetise.exceptions.MissingEntityById;
import fr.wf3.alphabetise.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdresseService implements IAdresseService {
    @Autowired
    private AdresseRepository adresseRepository;

    public Adresse addAdresse(Adresse adresse){
        System.err.println("dans le addAdresse");
        if(adresse.fullEntity()){
            return adresseRepository.save(adresse);
        } else {
            throw new EmptyFieldException("adresse");
        }
    }

    public Adresse updateAdresse(Adresse adresse){
        if(adresse.fullEntity()){
            return adresseRepository.save(adresse);
        } else {
            throw new EmptyFieldException("adresse");
        }
    }

    public Adresse findAdresseById(Long id){

        return adresseRepository.findById(id).orElseThrow(() -> new MissingEntityById("Adresse", id));
    }

    public List<Adresse> findAllAdresse(){
        return adresseRepository.findAll();
    }

    public void deleteAdresse(Long id){
        adresseRepository.deleteById(id);
    }

    public List<Adresse> addMultipleAdresses(List<Adresse> adresses){
        List<Adresse> toBeAdded = adresses.stream().filter(
                e -> e.fullEntity()
        ).collect(Collectors.toList());

        List<Adresse> notAdded = adresses.stream().filter(
                e -> !e.fullEntity()
        ).collect(Collectors.toList());

        for(Adresse e : notAdded){
            System.err.println(String.format("Adresse non ajouté à cause de champs obligatoires vides : %s", e.toString()));
        }

        return adresseRepository.saveAll(toBeAdded);
    }


}
