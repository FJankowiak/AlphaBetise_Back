package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adresses")
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
}
