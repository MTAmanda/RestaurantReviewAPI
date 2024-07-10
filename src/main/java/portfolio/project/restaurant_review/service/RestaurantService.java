package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> findAllRestaurants();
    Optional<Restaurant> findById(Long id);
    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant (Restaurant restaurant);
    void deleteRestaurant(Long Id);
}
