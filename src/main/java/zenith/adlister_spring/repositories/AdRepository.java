package zenith.adlister_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zenith.adlister_spring.models.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

}
