package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.dtos.LivreDTO;
import fr.wf3.alphabetise.repositories.LivreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {
    private  LivreRepository livreRepository;

    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<LivreDTO> booksList() {
        livreRepository.findAll().forEach(b->{

        });
        return null;
    }

    @Override
    public LivreDTO getBookById() {

        return null;
    }

    @Override
    public LivreDTO addNewBook() {

        return null;
    }

    @Override
    public void deleteBook(Long codeEAN) {

    }

    @Override
    public LivreDTO updateBook() {

        return null;
    }

//    @Override
//    public List<LivreDTO> searchBooks(String keyword) {
//
//        return null;
//    }
}
