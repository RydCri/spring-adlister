package zenith.adlister_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zenith.adlister_spring.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
