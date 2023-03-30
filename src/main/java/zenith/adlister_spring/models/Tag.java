package zenith.adlister_spring.models;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 55)
    private String name;

    @ManyToMany(mappedBy = "ads")
    private Set<Ad> ads;

    public Tag() {
    }
    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getTag_id() {
        return name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}