package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.DiningReview;

import java.util.List;
import java.util.Optional;

public interface DiningReviewService {
    List<DiningReview> findAllDiningReviews();
    Optional<DiningReview> findById(Long id);
    DiningReview saveDiningReview(DiningReview diningReview);
    DiningReview updateDiningReview (DiningReview diningReview);
    void deleteDiningReview(Long Id);
}
