package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.mappers.LivreMapperImpl;
import fr.wf3.alphabetise.repositories.LivreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LivreServiceImpl implements LivreService {
    private  LivreRepository livreRepository;
    private LivreMapperImpl MapperDto;


    @Override
    public List<LivreDTO> booksList() {
        List<Livre> livres = livreRepository.findAll();
        List<LivreDTO> livreDTOS = livres.stream()
                .map(livre -> MapperDto.fromBook(livre))
                .collect(Collectors.toList());
        /*
        List<LivreDTO> livreDTOS=new ArrayList<>();
        for (Livre livre:livres){
            LivreDTO livreDTO=dtoMapper.fromBook(livre);
            livreDTOS.add(livreDTO);
        }
        *
         */
        return livreDTOS;
    }

    @Override
    public LivreDTO getBookById(Long codeEAN) {
        Livre livre = livreRepository.findByCodeEAN(codeEAN);

        if(livre == null){
            return null;
        } else {
            return MapperDto.fromBook(livre);
        }
    }

    @Override
    public LivreDTO addNewBook(LivreDTO livreDTO) {
        return null;
    }



    @Override
    public void deleteBook(Long codeEAN) {

    }

    @Override
    public LivreDTO updateBook(LivreDTO livreDTO) {
        return null;
    }

    @Override
    public List<Livre> addMultipleLivres(List<Livre> livres) {
        return livreRepository.saveAll(livres);
    }

    @Override
    public List<Livre> findAllLivres() {
        return livreRepository.findAll();
    }


}
