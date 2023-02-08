package fr.wf3.alphabetise.dtos;

import fr.wf3.alphabetise.entities.Evenement;
import fr.wf3.alphabetise.entities.Livre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data


public class AuteurDTO {

   private Long id;

    private String prenom;

    private String nom;
   // private String pseudonyme;
   // private Date dateNaissance;


  //  private List<Livre> livres = new ArrayList<>();


  //  private List<Evenement> evenements = new ArrayList<>();



}
