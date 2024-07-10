package portfolio.project.restaurant_review.service;

import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.model.DiningReview;
import portfolio.project.restaurant_review.repository.DiningReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiningReviewServiceImpl implements DiningReviewService {
    private final DiningReviewRepository diningReviewRepository;

    public DiningReviewServiceImpl(DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }

    @Override
    public List<DiningReview> findAllDiningReviews() {
        return diningReviewRepository.findAll();
    }

    @Override
    public Optional<DiningReview> findById(Long id) {
        return diningReviewRepository.findById(id);
    }

    @Override
    public DiningReview saveDiningReview(DiningReview diningReview) {
        return diningReviewRepository.save(diningReview);
    }

    @Override
    public DiningReview updateDiningReview(DiningReview diningReview) {
        Optional<DiningReview> oldDiningReviewOptional = diningReviewRepository.findById(diningReview.getId());
        if (!oldDiningReviewOptional.isPresent()) {
            throw new RuntimeException("No Dining Review was found");
        }
        DiningReview oldDiningReview = oldDiningReviewOptional.get();

        if (diningReview.getReviewTitle() != null) {
            oldDiningReview.setReviewTitle(diningReview.getReviewTitle());
        }
        if (diningReview.getUserDisplayName() != null) {
            oldDiningReview.setUserDisplayName(diningReview.getUserDisplayName());
        }
        if (diningReview.getPeanutScore() != null) {
            oldDiningReview.setPeanutScore(diningReview.getPeanutScore());
        }
        if (diningReview.getEggScore() != null) {
            oldDiningReview.setEggScore(diningReview.getEggScore());
        }
        if (diningReview.getDairyScore() != null) {
            oldDiningReview.setDairyScore(diningReview.getDairyScore());
        }
        if (diningReview.getCommentary() != null) {
            oldDiningReview.setCommentary(diningReview.getCommentary());
        }
        return diningReviewRepository.save(oldDiningReview);
    }
    @Override
    public void deleteDiningReview(Long Id) {
        diningReviewRepository.deleteById(Id);
    }
}
