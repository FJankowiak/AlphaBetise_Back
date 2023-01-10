package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.repositories.EditeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EditeurService {
    @Autowired
    private EditeurRepository editeurRepository;

    public Editeur addEditeur(Editeur editeur){return editeurRepository.save(editeur);}

    public Editeur updateEditeur(Editeur editeur){return editeurRepository.save(editeur);}

    public Optional<Editeur> findEditeurById(Long id){
        return editeurRepository.findEditeurById(id);
    }

    public List<Editeur> findAllEditeur(){
        return editeurRepository.findAll();
    }

    public void deleteEditeur(Long id){
        editeurRepository.deleteEditeurById(id);
    }

    public List<Editeur> addMultipleEditeurs(List<Editeur> editeurs){
        return editeurRepository.saveAll(editeurs);
    }


}
