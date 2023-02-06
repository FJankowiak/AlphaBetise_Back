package fr.wf3.alphabetise.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AuteurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String email;
}
