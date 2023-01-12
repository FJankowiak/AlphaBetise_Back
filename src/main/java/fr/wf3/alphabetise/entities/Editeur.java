package fr.wf3.alphabetise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {"livres"})
@Table(name="editeurs")
public class Editeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_editeur")
    private long id; // à voir
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "editeur")
    private List<Livre> livres;

    public Editeur(String nom){
        this.nom = nom;
        this.livres = new ArrayList<>();
    }
}
