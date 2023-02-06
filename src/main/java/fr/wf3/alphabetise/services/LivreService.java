package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.LivreDTO;

import java.util.List;

public interface LivreService {
   List<LivreDTO> booksList();

   LivreDTO getBookById();
   LivreDTO addNewBook();

   void deleteBook(Long codeEAN);

   LivreDTO updateBook();

//   List<LivreDTO> searchBooks(String keyword);




}
