package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.dto.RestaurantDto;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantDto> findAllRestaurants();
    RestaurantDto findById(Long id);
    RestaurantDto saveRestaurant(RestaurantDto restaurantDto);
    RestaurantDto updateRestaurant(RestaurantDto restaurantDto);
    void deleteRestaurant(Long id);

    List<RestaurantDto> findRestaurantsByAllergy(Allergies allergy);
    List<RestaurantDto> findRestaurantsByZipcode(String zipcode);
}
