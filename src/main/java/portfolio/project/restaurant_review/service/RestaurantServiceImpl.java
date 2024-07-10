package portfolio.project.restaurant_review.service;

import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Optional<Restaurant> oldRestaurantOptional = restaurantRepository.findById(restaurant.getId());
        if (!oldRestaurantOptional.isPresent()) {
            throw new RuntimeException("No Restaurant was found");
        }
        Restaurant oldRestaurant = oldRestaurantOptional.get();

        if (restaurant.getName() != null) {
            oldRestaurant.setName(restaurant.getName());
        }
        if (restaurant.getAddress() != null) {
            oldRestaurant.setAddress(restaurant.getAddress());
        }
        if (restaurant.getCity() != null) {
            oldRestaurant.setCity(restaurant.getCity());
        }
        if (restaurant.getState() != null) {
            oldRestaurant.setState(restaurant.getState());
        }
        if (restaurant.getZipcode() != null) {
            oldRestaurant.setZipcode(restaurant.getZipcode());
        }
        return restaurantRepository.save(oldRestaurant);
    }
    @Override
    public void deleteRestaurant(Long Id) {
        restaurantRepository.deleteById(Id);
    }
}
