package fr.wf3.alphabetise.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="images")
@Data
@ToString(exclude = {"livre"})
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_image")
    private Long id;
    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name="livre_id")
    private Livre livre;

    public Image(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getImgUrl() {
        return "src\\assets\\images\\livres\\" + imgUrl;
    }
}
