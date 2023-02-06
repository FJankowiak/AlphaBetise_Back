package fr.wf3.alphabetise.exceptions;

public class MissingEntityById extends RuntimeException {
    public MissingEntityById(String entity, long id){
        super("Entité de type " + entity + " non trouvée pour un id de "+ id);
    }
}
