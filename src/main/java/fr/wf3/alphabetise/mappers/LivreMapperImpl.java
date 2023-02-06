package fr.wf3.alphabetise.mappers;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.entities.Livre;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LivreMapperImpl {
    public LivreDTO fromBook(Livre livre){
        LivreDTO livreDTO=new LivreDTO();
        BeanUtils.copyProperties(livre,livreDTO);
        return  livreDTO;
    }
    public Livre fromBookDTO(LivreDTO livreDTO){
        Livre livre=new Livre();
        BeanUtils.copyProperties(livreDTO,livre);
        return  livre;
    }


}
