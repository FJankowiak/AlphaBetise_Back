package fr.wf3.alphabetise.entities;

import javax.persistence.*;

@Entity
@Table(name = "lignes_commande")
public class LigneCommande {
    @Embeddable
    private LigneCommandeId id = new LigneCommandeId();

    @ManyToOne
    @MapsId("user")
    private Commande commande;

    @ManyToOne
    @MapsId("livre")
    private Livre livre;

    @Column(name = "prix_unitaire")
    private float prixUnitaire;
    private int quantite;

    public LigneCommande(Commande commande, Livre livre, int quantite){
        this.commande = commande;
        this.livre = livre;
        this.prixUnitaire = livre.getPrix();
        this.quantite = quantite;
    }
}
