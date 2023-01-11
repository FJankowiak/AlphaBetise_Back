package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeId {
    private Long commande;
    private Long livre;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((commande == null)? 0:commande.hashCode());
        result = result + ((livre == null)? 0:livre.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        LigneCommandeId other = (LigneCommandeId) obj;
        return Objects.equals(getLivre(), other.getLivre()) && Objects.equals(commande, other.getCommande());
    }
}
