package fr.wf3.alphabetise.entities;

import fr.wf3.alphabetise.embeddedClasses.NotePK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//@Entity
//@Table(name = "notes")
//@Data @NoArgsConstructor @AllArgsConstructor
//@ToString(exclude = {"user"})
public class Note {
    // Pour inclure deux Id dans cette table, on inclut l'id dans les attributs
//    @EmbeddedId
//    private NotePK id = new NotePK();
//
//    @ManyToOne
//    @MapsId("user")
//    private User user;
//
//    @ManyToOne
//    @MapsId("livre")
//    private Livre livre;
//
//    // Attributs supplémentaires - qui fait qu'on a pas pu utiliser un simple @ManyToMany
//    private float note;
//    @Column(nullable = false)
//    private String avis;
//
//    public Note(User user, Livre livre, float note, String avis) {
//        // Créer l'id sur la base de l'id des deux éléments
//        this.id = new NotePK(user.getId(), livre.getCodeEAN());
//        this.user = user;
//        this.livre = livre;
//        this.note = note;
//        this.avis = avis;
//    }
}
