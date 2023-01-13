package fr.wf3.alphabetise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="livres")
@Data
@ToString(exclude = {"lignesCommande"})
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @Column(name="code_ean")
    private Long codeEAN;
    @Column(name="code_isbn")
    private String codeISBN;
    private String titre;
    private String resume;
    private String collection;
    @Column(name="date_parution")
    private Date dateParution; // à voir
    private int quantite;
    private float prix;
//    private String imgURL;

    @ManyToOne
    @JoinColumn(name="editeur_id", nullable = false)
    private Editeur editeur;

    @OneToMany(mappedBy = "livre")
    private List<Note> notes = new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "T_Livres_Auteurs_Associations",
            joinColumns = @JoinColumn( name = "code_ean" ),
            inverseJoinColumns = @JoinColumn( name = "id_auteur" ) )
    private List<Auteur> auteurs = new ArrayList<>();

    @OneToMany(mappedBy = "livre")
    private List<Image> images;

    @OneToMany (mappedBy = "livre")
    private Set<LigneCommande> ligneCommandes = new HashSet<>();

    @JsonIgnore
    public Set<LigneCommande> getLigneCommandes(){
        return ligneCommandes;
    }

    public Double calculerNotes(){
        if(notes.size() == 0){
            return null;
        } else{
            List<Float> values = notes.stream().map(Note::getNote).collect(Collectors.toList());

            Double mean = values.stream().mapToDouble(a -> a).average().getAsDouble();
            return mean;
        }
    }

    //constructors

    //getters and setters



}
