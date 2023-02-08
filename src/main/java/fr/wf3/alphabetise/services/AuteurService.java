package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.AuteurDTO;

import java.util.List;

public interface AuteurService {
    List<AuteurDTO> authorsList();

    AuteurDTO getAuthorById(Long id_auteur);

    AuteurDTO saveAuthor(AuteurDTO AuteurDTO);


    void deleteAuthor(Long id_auteur);

    AuteurDTO updateAuthor(AuteurDTO auteurDTO);
}
