package portfolio.project.restaurant_review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
}
