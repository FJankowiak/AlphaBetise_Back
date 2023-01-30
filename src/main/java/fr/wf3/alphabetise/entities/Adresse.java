package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adresses")
@ToString(exclude = "user")
public class Adresse {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_adresse")
    private Long id;
    private String adresse;
   @Column(name = "complement_adresse")
    private String complementAdresse;
   @Column(name = "code_postal")
    private String codePostal;
    private String ville;
    @OneToOne(mappedBy = "adresse")
    private User user;


    public Adresse(String adresse, String complementAdresse, String codePostal, String ville) {
        this.adresse = adresse;
        this.complementAdresse = complementAdresse;
        this.codePostal = codePostal;
        this.ville = ville;

        this.user = null;
    }
}
