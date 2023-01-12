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
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
public class Auteur {
    @Id
    @Column(name="id_auteur")
    private Long id;
    private String prenom;
    private String nom;
    private Date dateNaissance;

    @ManyToMany(mappedBy = "auteurs")
    private List<Livre> livres = new ArrayList<>();
//    @JoinTable( name = "T_Livres_Auteurs_Associations",
//            joinColumns = @JoinColumn( name = "id_auteur" ),
//            inverseJoinColumns = @JoinColumn( name = "code_ean" ) )




}
