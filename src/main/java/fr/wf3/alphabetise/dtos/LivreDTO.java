package fr.wf3.alphabetise.dtos;


import lombok.Data;

import java.util.Date;

@Data
public class LivreDTO {

    private Long codeEAN;

    private String codeISBN;
    private String titre;
    private String resume;
    private String collection;
    private String mainImgUrl;

    private Date dateParution; // à voir
    private int quantite;
    private float prix;


    private String notesBiographiques;

//    private float moyenne;
//    private float nbVotants;








}
