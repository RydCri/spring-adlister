package zenith.adlister_spring.models;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="tags")
public class Tag {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 55)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Ad> ads;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

}