package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Data @NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {"user"})
public class Note {
    @EmbeddedId
    private NoteId id = new NoteId();

    @ManyToOne
    @MapsId("user")
    private User user;

    @ManyToOne
    @MapsId("livre")
    private Livre livre;

    private float note;
    @Column(nullable = false)
    private String avis;

    public Note(User user, Livre livre, float note, String avis) {
        this.id = new NoteId(user.getId(), livre.getCodeEAN());
        this.user = user;
        this.livre = livre;
        this.note = note;
        this.avis = avis;
    }
}
