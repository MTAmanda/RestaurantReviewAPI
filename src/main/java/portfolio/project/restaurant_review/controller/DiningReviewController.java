package portfolio.project.restaurant_review.controller;

import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.model.DiningReview;
import portfolio.project.restaurant_review.service.DiningReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diningReviews")
public class DiningReviewController {

    private final DiningReviewService diningReviewService;

    public DiningReviewController(DiningReviewService diningReviewService) {
        this.diningReviewService = diningReviewService;
    }

    @GetMapping
    public List<DiningReview> findAllDiningReviews(){
        return diningReviewService.findAllDiningReviews();
    }

    @GetMapping("/{Id}")
    public Optional<DiningReview> findDiningReviewById(@PathVariable("Id") Long Id){
        return diningReviewService.findById(Id);
    }

    @PostMapping
    public DiningReview saveDiningReview(@RequestBody DiningReview diningReview){
        return diningReviewService.saveDiningReview(diningReview);
    }

    @PutMapping("/{Id}")
    public DiningReview diningReview(@PathVariable("Id") Long Id, @RequestBody DiningReview diningReview){
        return diningReviewService.updateDiningReview(diningReview);
    }

    @DeleteMapping("/{Id}")
    public void deleteDiningReview(@PathVariable("Id") Long Id){
        diningReviewService.deleteDiningReview(Id);
    }
}
