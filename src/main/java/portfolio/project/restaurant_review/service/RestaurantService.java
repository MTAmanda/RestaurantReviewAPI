package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.model.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantDTO> findAllRestaurants();
    Optional<RestaurantDTO> findById(Long id);
    RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO);
    void deleteRestaurant(Long id);

    List<RestaurantDTO> findRestaurantsByAllergy(Allergies allergy);
    List<RestaurantDTO> findRestaurantsByZipcode(String zipcode);
}
