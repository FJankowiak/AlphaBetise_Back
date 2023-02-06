package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.exceptions.EmptyFieldException;
import fr.wf3.alphabetise.exceptions.MissingEntityById;
import fr.wf3.alphabetise.repositories.EditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EditeurService implements IEditeurService {
    @Autowired
    private EditeurRepository editeurRepository;

    public Editeur addEditeur(Editeur editeur){
        if(editeur.fullEntity()){
            return editeurRepository.save(editeur);
        } else {
            throw new EmptyFieldException("editeur");
        }
    }

    public Editeur updateEditeur(Editeur editeur){
        if(editeur.fullEntity()){
            return editeurRepository.save(editeur);
        } else {
            throw new EmptyFieldException("editeur");
        }
    }

    public Editeur findEditeurById(Long id){

        return editeurRepository.findEditeurById(id).orElseThrow(() -> new MissingEntityById("Editeur", id));
    }

    public List<Editeur> findAllEditeur(){
        return editeurRepository.findAll();
    }

    public void deleteEditeur(Long id){
        editeurRepository.deleteEditeurById(id);
    }

    public List<Editeur> addMultipleEditeurs(List<Editeur> editeurs){
        List<Editeur> toBeAdded = editeurs.stream().filter(
                e -> e.fullEntity()
        ).collect(Collectors.toList());

        List<Editeur> notAdded = editeurs.stream().filter(
                e -> !e.fullEntity()
        ).collect(Collectors.toList());

        for(Editeur e : notAdded){
            System.err.println(String.format("Editeur non ajouté à cause de champs obligatoires vides : %s", e.toString()));
        }

        return editeurRepository.saveAll(toBeAdded);
    }


}
