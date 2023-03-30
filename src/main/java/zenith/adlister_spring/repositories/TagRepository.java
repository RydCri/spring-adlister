package zenith.adlister_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zenith.adlister_spring.models.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findTagByName(String name);
}
