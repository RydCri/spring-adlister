package zenith.adlister_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zenith.adlister_spring.models.Ad;

import java.math.BigInteger;

public interface AdRepository extends JpaRepository<Ad, BigInteger> {
}
