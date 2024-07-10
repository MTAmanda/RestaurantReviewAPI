package portfolio.project.restaurant_review.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DISPLAYNAME")
    private String displayName;
    @Column(name="INTEREST_PEANUT")
    private boolean interestedInPeanutAllergy;
    @Column(name="INTEREST_EGG")
    private boolean interestedInEggAllergy;
    @Column(name="INTEREST_DAIRY")
    private boolean interestedInDairyAllergy;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DiningReview> reviews;
}
