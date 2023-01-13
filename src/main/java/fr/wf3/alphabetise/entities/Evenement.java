package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evenements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"users"})
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evenement_id")
    private long id;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String descriptif;
    private LocalDateTime date;
    // Est ce qu'il s'agit de minutes ou d'heures
    // long ne peut pas être null
    private long duree;
    @Column(nullable = false)
    private String lieu;
    @Column(name = "reservation")
    private boolean reservationNecessaire;
    @Column(name = "nombre_participants")
    private int nbParticipants;
    private float prix;

    @ManyToMany(mappedBy = "evenements")
    private List<User> users;

    @ManyToMany(mappedBy = "evenements")
    private List<Auteur> auteurs;


    public Evenement(String titre, String descriptif, LocalDateTime date, long duree, String lieu, boolean reservationNecessaire, int nbParticipants, float prix) {
        this.titre = titre;
        this.descriptif = descriptif;
        this.date = date;
        this.duree = duree;
        this.lieu = lieu;
        this.reservationNecessaire = reservationNecessaire;
        this.nbParticipants = nbParticipants;
        this.prix = prix;

        this.users = new ArrayList<>();
        this.auteurs = new ArrayList<>();
    }

    public Evenement(String titre, String descriptif, LocalDateTime date, long duree, String lieu, boolean reservationNecessaire, int nbParticipants, float prix, List<Auteur> auteurs) {
        this.titre = titre;
        this.descriptif = descriptif;
        this.date = date;
        this.duree = duree;
        this.lieu = lieu;
        this.reservationNecessaire = reservationNecessaire;
        this.nbParticipants = nbParticipants;
        this.prix = prix;

        this.users = new ArrayList<>();
        this.auteurs = auteurs;
    }


}
