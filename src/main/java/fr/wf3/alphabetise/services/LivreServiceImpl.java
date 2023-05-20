package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.mappers.LivreMapperImpl;
import fr.wf3.alphabetise.repositories.LivreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class LivreServiceImpl implements LivreService {
    private  LivreRepository livreRepository;
    private LivreMapperImpl mapperDto;


    @Override
    public List<LivreDTO> booksList() {
        List<Livre> livres = livreRepository.findAll();
        List<LivreDTO> livreDTOS = livres.stream()
                .map(livre -> mapperDto.fromBook(livre))
                .collect(Collectors.toList());
        /*
        List<LivreDTO> livreDTOS=new ArrayList<>();
        for (Livre livre:livres){
            LivreDTO livreDTO=MapperDto.fromBook(livre);
            livreDTOS.add(livreDTO);
        }
        *
         */
        return livreDTOS;
    }

    @Override
    public LivreDTO getBookById(Long codeEAN) throws BookNotFoundException {
        Livre livre = livreRepository.findById(codeEAN)
                .orElseThrow(() -> new BookNotFoundException("Book Not found"));
        return mapperDto.fromBook(livre);

    }

    @Override
    public LivreDTO addNewBook(LivreDTO livreDTO) {
        Livre livre=mapperDto.fromBookDTO(livreDTO);
        Livre ajoutLivre= livreRepository.save(livre);
        return mapperDto.fromBook(ajoutLivre);
    }



    @Override
    public void deleteBook(Long codeEAN) {
        livreRepository.deleteById(codeEAN);
    }

    @Override
    public LivreDTO updateBook(LivreDTO livreDTO) {
        Livre livre=mapperDto.fromBookDTO(livreDTO);
        Livre modifLivre = livreRepository.save(livre);
        return mapperDto.fromBook(modifLivre);
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
