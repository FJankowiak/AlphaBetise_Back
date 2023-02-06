package fr.wf3.alphabetise.exceptions;

import fr.wf3.alphabetise.entities.Livre;

public class CodeEanAlreadyInBase extends RuntimeException{
    public CodeEanAlreadyInBase(Livre livre){
        super("Un livre avec l'EAN '" + livre.getCodeEAN()+ "' est déjà présent en base de données vavec le titre '" + livre.getTitre() +"'");
    }
}
