package fr.wf3.alphabetise.exceptions;

public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException(String entity){
        super(String.format("Objet de type %s non enregistré : un ou plusieurs champs sont vides", entity));
    }
}
