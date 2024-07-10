package portfolio.project.restaurant_review.repository;

import portfolio.project.restaurant_review.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDisplayName(String displayName);
    void deleteUserByDisplayName(String displayName);

}
