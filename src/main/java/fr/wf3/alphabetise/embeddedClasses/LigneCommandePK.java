package fr.wf3.alphabetise.embeddedClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandePK implements Serializable {
    // La problématique de ce ManyToMany "maison" est qu'il y a des attributs supplémentaires dans la table de liaison
    // Cet Id composé de deux éléments se traduira par deux colonnes dans la table dans laquelle cet id sera "inclus" (embedded)

    private Long commande;
    private String livre;

    // Nécessaire pour la comparaison entre Ids
    @Override
    public int hashCode(){
        // Nombre premier, choisi aléatoirement
        final int prime = 31;
        int result = 1;
        // Calcul "maison" du hashcode au cas où
        // Initialiser la valeur à 31 (1*31), puis on ajoute les hashcodes de tous les attributs
        result = prime * result + ((commande == null)? 0:commande.hashCode());
        result = result + ((livre == null)? 0:livre.hashCode());

        return result;
    }

    // Comparateur entre le Id composite et un autre objet (de type LigneCommandeId idéalement)
    // Servira pour Java, par exemple pour l'ajout ou non d'éléments dans un set
    @Override
    public boolean equals(Object obj){
        // Si l'objet est comparable "simplement", on renvoie true
        if(this == obj){
            return true;
        }
        // Si l'autre objet est null, on renvoie false (comparer deux nulls est pas vraiment pertinent...)
        if (obj == null){
            return false;
        }

        // Si l'autre objet n'est pas de la même classe que celui ci (ou hérité ?), on renvoie false
        if(getClass() != obj.getClass()){
            return false;
        }

        // Si on a pas été dans un des autres if, on compare les attributs de cet objet
        // Dans le cas actuel, on compare le String de codeEAN et le Long de idCommande
        LigneCommandePK other = (LigneCommandePK) obj;
        return Objects.equals(getLivre(), other.getLivre()) && Objects.equals(commande, other.getCommande());
    }
}
