package portfolio.project.restaurant_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findBySupportedAllergiesContaining(Allergies allergy);
    List<Restaurant> findByZipcode(String zipcode);
    List<Restaurant> findByName(String name);

    @Query("SELECT r FROM Restaurant r WHERE r.name = :name AND r.zipcode = :zipcode")
    Optional<Restaurant> findByNameAndZipcode(@Param("name") String name, @Param("zipcode") String zipcode);

    @Query("SELECT r, COUNT(dr) AS scoreCount " +
            "FROM Restaurant r " +
            "JOIN r.reviews dr " +
            "WHERE r.zipcode = :zipcode " +
            "AND (dr.peanutScore IS NOT NULL OR dr.eggScore IS NOT NULL OR dr.dairyScore IS NOT NULL) " +
            "GROUP BY r " +
            "ORDER BY scoreCount DESC")
    List<Object[]> findRestaurantsByZipcodeWithScoresOrderedByScoreCount(@Param("zipcode") String zipcode);
}
