package portfolio.project.restaurant_review.service;

import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.model.RestaurantDTO;
import portfolio.project.restaurant_review.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(RestaurantDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RestaurantDTO> findById(Long id) {
        return restaurantRepository.findById(id).map(RestaurantDTO::new);
    }

    @Override
    public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant(restaurantDTO); // Create Restaurant entity from DTO
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return new RestaurantDTO(savedRestaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Optional<Restaurant> oldRestaurantOptional = restaurantRepository.findById(restaurantDTO.getId());
        if (!oldRestaurantOptional.isPresent()) {
            throw new RuntimeException("No Restaurant was found");
        }
        Restaurant oldRestaurant = oldRestaurantOptional.get();

        if (restaurantDTO.getName() != null) {
            oldRestaurant.setName(restaurantDTO.getName());
        }
        if (restaurantDTO.getAddress() != null) {
            oldRestaurant.setAddress(restaurantDTO.getAddress());
        }
        if (restaurantDTO.getCity() != null) {
            oldRestaurant.setCity(restaurantDTO.getCity());
        }
        if (restaurantDTO.getState() != null) {
            oldRestaurant.setState(restaurantDTO.getState());
        }
        if (restaurantDTO.getZipcode() != null) {
            oldRestaurant.setZipcode(restaurantDTO.getZipcode());
        }

        Restaurant updatedRestaurant = restaurantRepository.save(oldRestaurant);
        return new RestaurantDTO(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantDTO> findRestaurantsByAllergy(Allergies allergy) {
        List<Restaurant> restaurants = restaurantRepository.findBySupportedAllergiesContaining(allergy);
        return restaurants.stream()
                .map(RestaurantDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDTO> findRestaurantsByZipcode(String zipcode) {
        List<Restaurant> restaurants = restaurantRepository.findByZipcode(zipcode);
        return restaurants.stream()
                .map(RestaurantDTO::new)
                .collect(Collectors.toList());
    }
}