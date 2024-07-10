package portfolio.project.restaurant_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio.project.restaurant_review.model.DiningReview;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
}
