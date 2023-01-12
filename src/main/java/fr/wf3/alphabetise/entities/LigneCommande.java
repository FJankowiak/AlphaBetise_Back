package fr.wf3.alphabetise.entities;

import fr.wf3.alphabetise.embeddedClasses.LigneCommandeId;

import javax.persistence.*;

@Entity
@Table(name = "lignes_commande")
public class LigneCommande {
    // Pour inclure deux Id dans cette table, on inclut l'id dans les attributs
    @EmbeddedId
    private LigneCommandeId id = new LigneCommandeId();

    @ManyToOne
    @MapsId("user")
    private Commande commande;

    @ManyToOne
    @MapsId("livre")
    private Livre livre;

    // Attributs supplémentaires - qui fait qu'on a pas pu utiliser un simple @ManyToMany
    @Column(name = "prix_unitaire")
    private float prixUnitaire;
    private int quantite;

    public LigneCommande(Commande commande, Livre livre, int quantite){
        // Créer l'id sur la base de l'id des deux éléments
        this.id = new LigneCommandeId(commande.getId(), livre.getCodeEAN());

        this.commande = commande;
        this.livre = livre;

        // Le prix au moment où la commande est passée, sur la base de ce que le back connait du livre à cet instant T
        // Ca permet de garder la facture valide même si le prix venait à changer
        this.prixUnitaire = livre.getPrix();

        this.quantite = quantite;
    }
}
