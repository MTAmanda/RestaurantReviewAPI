package portfolio.project.restaurant_review.model;
import lombok.Data;

@Data
public class UserDTO {

    private String displayName;
    private boolean interestedInPeanutAllergy;
    private boolean interestedInEggAllergy;
    private boolean interestedInDairyAllergy;
    private int reviewCount;

    public UserDTO() {
    }

    // Constructor to map from User entity
    public UserDTO(User user) {
        this.displayName = user.getDisplayName();
        this.interestedInPeanutAllergy = user.isInterestedInPeanutAllergy();
        this.interestedInEggAllergy = user.isInterestedInEggAllergy();
        this.interestedInDairyAllergy = user.isInterestedInDairyAllergy();
        this.reviewCount = user.getReviews() != null ? user.getReviews().size() : 0;
    }
}