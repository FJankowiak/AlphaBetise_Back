package fr.wf3.alphabetise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.wf3.alphabetise.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
//@ToString()
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @JsonIgnore
    private Long id;
    private String nom;
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;
    @JsonIgnore
    private String password;
    @OneToOne
//    @Column(name = "adresse_id")
    private Adresse adresse;
//    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Commande> commandes;

    @ManyToMany
    @JoinTable( name = "t_users_evenements",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_evenement"))
    private List<Evenement> evenements = new ArrayList<>();

    public User(String nom, String prenom, String email, String password, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;

        this.commandes = new ArrayList<>();
        this.role = Role.CLIENT;
        this.evenements = new ArrayList<>();
    }

    public User(String nom, String prenom, String email, String password, Adresse adresse, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.role = role;

        this.commandes = new ArrayList<>();
        this.evenements = new ArrayList<>();
    }

    public boolean fullEntity(){
        return nom != null && !nom.equals("")
                && prenom != null && !prenom.equals("")
                && password != null && !password.equals("")
                && adresse.fullEntity()
                ;
    }

}
