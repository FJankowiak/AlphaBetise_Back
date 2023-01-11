package fr.wf3.alphabetise.entities;

import fr.wf3.alphabetise.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @OneToOne
    private Adresse adresse;
    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "users")
    private List<Note> notes = new ArrayList<>();
}
