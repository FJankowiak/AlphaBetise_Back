package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.embeddedClasses.NotePK;
import fr.wf3.alphabetise.entities.LigneCommande;
import fr.wf3.alphabetise.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, NotePK> {
    public List<Note> findByUserId(long id);

    public List<Note> findByLivreCodeEAN(Long codeEAN);

    public Note findByUserIdAndLivreCodeEAN(long id, Long codeEAN);
}
