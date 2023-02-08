package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.AuteurDTO;
import fr.wf3.alphabetise.entities.Auteur;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.exceptions.AuthorNotFoundException;
import fr.wf3.alphabetise.exceptions.BookNotFoundException;
import fr.wf3.alphabetise.mappers.AuteurMapperImpl;
import fr.wf3.alphabetise.repositories.AuteurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AuteurServiceImpl implements AuteurService{

    private AuteurRepository auteurRepository;
    private AuteurMapperImpl mapperAuteurDto;

   // Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public List<AuteurDTO> authorsList() {
        log.info("Display all authors");
        List<Auteur> auteurs = auteurRepository.findAll();
        List<AuteurDTO> auteurDTOS = auteurs.stream()
                .map(auteur -> mapperAuteurDto.fromAuteur(auteur))
                .collect(Collectors.toList());
        return auteurDTOS;
    }

    @Override
    public AuteurDTO getAuthorById(Long id_auteur) throws AuthorNotFoundException {
        Auteur auteur = auteurRepository.findById(id_auteur)
                .orElseThrow(() -> new AuthorNotFoundException("Author Not found"));
        return mapperAuteurDto.fromAuteur(auteur);
    }

    @Override
    public AuteurDTO saveAuthor(AuteurDTO auteurDTO) {
        Auteur auteur=mapperAuteurDto.fromAuteurDTO(auteurDTO);
        Auteur ajoutAuteur= auteurRepository.save(auteur);
        return mapperAuteurDto.fromAuteur(ajoutAuteur);
    }

    @Override
    public void deleteAuthor(Long id_auteur) {
        auteurRepository.deleteById(id_auteur);
    }

    @Override
    public AuteurDTO updateAuthor(AuteurDTO auteurDTO) {
        Auteur auteur=mapperAuteurDto.fromAuteurDTO(auteurDTO);
        Auteur modifAuteur = auteurRepository.save(auteur);
        return mapperAuteurDto.fromAuteur(modifAuteur);
    }
}
