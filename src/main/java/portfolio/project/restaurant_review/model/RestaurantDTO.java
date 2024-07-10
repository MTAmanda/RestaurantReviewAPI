package portfolio.project.restaurant_review.model;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    // Constructor to map from Restaurant entity
    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.city = restaurant.getCity();
        this.state = restaurant.getState();
        this.zipcode = restaurant.getZipcode();
    }
}
