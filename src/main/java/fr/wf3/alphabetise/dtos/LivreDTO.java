package fr.wf3.alphabetise.dtos;


import lombok.Data;

import java.util.Date;

@Data
public class LivreDTO {



   // private String codeISBN;
    private String titre;
    private Long codeEAN;
    private float prix;

    private String auteur;

    private String resume;

    private String categorie;

    private String notesBiographiques;

   // private Date dateParution; // à voir
   // private int quantite;










}
