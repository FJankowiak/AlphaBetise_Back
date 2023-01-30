package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Editeur;
import fr.wf3.alphabetise.entities.Note;

import java.util.List;
import java.util.Optional;

public interface INoteService {
    public Note addNote(Note note);
    public Note updateNote(Note note);
    public Optional<Note> findNoteById(Long id);
    public List<Note> findAllNote();
    public void deleteNote(Long id);
//    public List<Note> addMultipleNotes(List<Note> notes);
}
