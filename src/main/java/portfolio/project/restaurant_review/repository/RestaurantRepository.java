package portfolio.project.restaurant_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findBySupportedAllergiesContaining(Allergies allergy);
    List<Restaurant> findByZipcode(String zipcode);
}
