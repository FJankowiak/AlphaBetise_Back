package fr.wf3.alphabetise.mappers;

import fr.wf3.alphabetise.dtos.AuteurDTO;
import fr.wf3.alphabetise.entities.Auteur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AuteurMapperImpl {
    public AuteurDTO fromAuteur(Auteur auteur){
        AuteurDTO auteurDTO=new AuteurDTO();
        BeanUtils.copyProperties(auteur,auteurDTO);
        return  auteurDTO;
    }
    public Auteur fromAuteurDTO(AuteurDTO auteurDTO){
        Auteur auteur=new Auteur();
        BeanUtils.copyProperties(auteurDTO,auteur);
        return  auteur;
    }


}
