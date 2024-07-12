package portfolio.project.restaurant_review.dto;
import lombok.Data;
import portfolio.project.restaurant_review.model.User;

@Data
public class UserDto {

    private String displayName;
    private boolean interestedInPeanutAllergy;
    private boolean interestedInEggAllergy;
    private boolean interestedInDairyAllergy;
    private int reviewCount;
/*
    public UserDto() {
    }

    // Constructor to map from User entity
    public UserDto(User user) {
        this.displayName = user.getDisplayName();
        this.interestedInPeanutAllergy = user.isInterestedInPeanutAllergy();
        this.interestedInEggAllergy = user.isInterestedInEggAllergy();
        this.interestedInDairyAllergy = user.isInterestedInDairyAllergy();
        this.reviewCount = user.getReviews() != null ? user.getReviews().size() : 0;
    }
 */
}