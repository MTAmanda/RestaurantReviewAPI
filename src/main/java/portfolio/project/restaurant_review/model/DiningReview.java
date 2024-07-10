package portfolio.project.restaurant_review.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="DINING_REVIEWS")
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="REVIEW_TITLE")
    private String reviewTitle;
    @Column(name="USER_NAME")
    private String userDisplayName;
    @Column(name="PEANUT_SCORE")
    private Integer peanutScore;
    @Column(name="EGG_SCORE")
    private Integer eggScore;
    @Column(name="DAIRY_SCORE")
    private Integer dairyScore;
    @Column(name="COMMENTARY")
    private String commentary;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
