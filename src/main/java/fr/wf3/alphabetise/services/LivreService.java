package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.LivreDTO;

import java.util.List;

public interface LivreService {
   List<LivreDTO> booksList();

   LivreDTO getBookById(Long codeEAN);

   LivreDTO addNewBook(LivreDTO livreDTO);


   void deleteBook(Long codeEAN);

   LivreDTO updateBook(LivreDTO livreDTO);




}
