package fr.wf3.alphabetise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime date;

    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes = new HashSet<>();

    @JsonIgnore
    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }



}
