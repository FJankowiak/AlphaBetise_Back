package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="auteurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"evenements"})
public class Auteur {

    @Id
    @Column(name="id_auteur")
    private Long id;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    private String pseudonyme;
    private Date dateNaissance;

    @ManyToMany(mappedBy = "auteurs")
    private List<Livre> livres = new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "T_auteurs_evenements",
            joinColumns = @JoinColumn(name = "id_auteur"),
            inverseJoinColumns = @JoinColumn(name = "id_evenement"))
    private List<Evenement> evenements = new ArrayList<>();
//    @JoinTable( name = "T_Livres_Auteurs_Associations",
//            joinColumns = @JoinColumn( name = "id_auteur" ),
//            inverseJoinColumns = @JoinColumn( name = "code_ean" ) )


    public Auteur(String prenom, String nom, String pseudonyme, Date dateNaissance, List<Livre> livres) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = pseudonyme;
        this.dateNaissance = dateNaissance;

        this.livres = livres;
        this.evenements = new ArrayList<>();
    }

    public Auteur(String prenom, String nom, Date dateNaissance, List<Livre> livres) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = "";
        this.dateNaissance = dateNaissance;

        this.livres = livres;
        this.evenements = new ArrayList<>();
    }

    public Auteur(String prenom, String nom, String pseudonyme, Date dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = pseudonyme;
        this.dateNaissance = dateNaissance;

        this.livres = new ArrayList<>();
        this.evenements = new ArrayList<>();
    }
    public Auteur(String prenom, String nom, Date dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = "";
        this.dateNaissance = dateNaissance;

        this.livres = new ArrayList<>();
        this.evenements = new ArrayList<>();
    }

    public Auteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = "";
        this.dateNaissance = null;

        this.livres = new ArrayList<>();
        this.evenements = new ArrayList<>();
    }

    public Auteur(String prenom, String nom, String pseudonyme) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudonyme = pseudonyme;
        this.dateNaissance = null;

        this.livres = new ArrayList<>();
        this.evenements = new ArrayList<>();
    }
}
