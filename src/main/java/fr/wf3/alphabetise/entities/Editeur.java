package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {})
@Table(name="editeurs")
public class Editeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_editeur")
    private Long id; // à voir
    private String nom;

    @OneToMany(mappedBy = "editeur")
    private List<Livre> livres;
}
