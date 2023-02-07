package fr.wf3.alphabetise.enums;

public enum Categorie {
    ADOS("Romans Jeunesse"), ENFANTS("Jeunesse tout petits"), BEBES("Jeunesse 0-7ans"), ROMANS_ADULTES("Romans graphiques");

    private final String categorie;

    Categorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie(){
        return categorie;
    }
}
