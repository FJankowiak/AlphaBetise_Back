package fr.wf3.alphabetise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="commandes")
@Data
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @Column(name="id_commande")
    private Long id;
    private Date date;

    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligne_commandes = new HashSet<>();

    @JsonIgnore
    public Set<LigneCommande> getLigneCommandes(){
        return ligne_commandes;



}
