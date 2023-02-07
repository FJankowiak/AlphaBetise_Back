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

    @Column(name="notes_biographiques")
    private String notesBiographiques;
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

    public Double getMoyenne(){
        if(notes.size() == 0){
            return null;
        } else{
            List<Float> values = notes.stream().map(Note::getNote).collect(Collectors.toList());

            Double mean = values.stream().mapToDouble(a -> a).average().getAsDouble();
            return mean;
        }
    }

    public int getNbVotants(){
        return (notes == null)? 0 : notes.size();
    }

    //constructors

    // Constructeur sans notes bio, avec ISBN

    public Livre(Long codeEAN, String codeISBN, String titre, String resume, String collection, Date dateParution, int quantite, float prix, Editeur editeur, List<Auteur> auteurs, List<Image> images) {
        this.codeEAN = codeEAN;
        this.titre = titre;
        this.resume = resume;
        this.collection = collection;
        this.dateParution = dateParution;
        this.quantite = quantite;
        this.prix = prix;
        this.editeur = editeur;
        this.auteurs = auteurs;
        this.images = images;

        this.codeISBN = codeISBN;
        this.notesBiographiques = "";
    }
    // Constructeur avec notes bio, avec ISBN

    public Livre(Long codeEAN, String codeISBN, String titre, String resume, String collection, Date dateParution, int quantite, float prix, Editeur editeur, String notesBiographiques, List<Auteur> auteurs, List<Image> images) {
        this.codeEAN = codeEAN;
        this.titre = titre;
        this.resume = resume;
        this.collection = collection;
        this.dateParution = dateParution;
        this.quantite = quantite;
        this.prix = prix;
        this.editeur = editeur;
        this.auteurs = auteurs;
        this.images = images;

        this.codeISBN = codeISBN;
        this.notesBiographiques = notesBiographiques;
    }
    // Constructeur sans notes bio, sans ISBN

    public Livre(Long codeEAN, String titre, String resume, String collection, Date dateParution, int quantite, float prix, Editeur editeur, List<Auteur> auteurs, List<Image> images) {
        this.codeEAN = codeEAN;
        this.titre = titre;
        this.resume = resume;
        this.collection = collection;
        this.dateParution = dateParution;
        this.quantite = quantite;
        this.prix = prix;
        this.editeur = editeur;
        this.auteurs = auteurs;
        this.images = images;

        this.codeISBN = "";
        this.notesBiographiques = "";
    }

    // Constructeur avec notes bio, sans ISBN
    public Livre(Long codeEAN, String titre, String resume, String collection, Date dateParution, int quantite, float prix, Editeur editeur, String notesBiographiques, List<Auteur> auteurs, List<Image> images) {
        this.codeEAN = codeEAN;
        this.titre = titre;
        this.resume = resume;
        this.collection = collection;
        this.dateParution = dateParution;
        this.quantite = quantite;
        this.prix = prix;
        this.editeur = editeur;
        this.auteurs = auteurs;
        this.images = images;

        this.codeISBN = "";
        this.notesBiographiques = notesBiographiques;
    }


    //getters and setters



}
