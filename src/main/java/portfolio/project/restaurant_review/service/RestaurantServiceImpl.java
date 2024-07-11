package portfolio.project.restaurant_review.service;

import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.dto.mapper.RestaurantMapper;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.dto.RestaurantDto;
import portfolio.project.restaurant_review.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(RestaurantDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto findById(Long id) {
        Restaurant restaurant = restaurantRepository.getReferenceById(id);
        return restaurantMapper.map(restaurant);
    }

    @Override
    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.map(restaurantDto); // Create Restaurant entity from Dto
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.map(savedRestaurant);
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto) {
        Optional<Restaurant> oldRestaurantOptional = restaurantRepository.findById(restaurantDto.getId());
        if (!oldRestaurantOptional.isPresent()) {
            throw new RuntimeException("No Restaurant was found");
        }
        Restaurant oldRestaurant = oldRestaurantOptional.get();

        if (restaurantDto.getName() != null) {
            oldRestaurant.setName(restaurantDto.getName());
        }
        if (restaurantDto.getAddress() != null) {
            oldRestaurant.setAddress(restaurantDto.getAddress());
        }
        if (restaurantDto.getCity() != null) {
            oldRestaurant.setCity(restaurantDto.getCity());
        }
        if (restaurantDto.getState() != null) {
            oldRestaurant.setState(restaurantDto.getState());
        }
        if (restaurantDto.getZipcode() != null) {
            oldRestaurant.setZipcode(restaurantDto.getZipcode());
        }

        Restaurant updatedRestaurant = restaurantRepository.save(oldRestaurant);
        return new RestaurantDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantDto> findRestaurantsByAllergy(Allergies allergy) {
        List<Restaurant> restaurants = restaurantRepository.findBySupportedAllergiesContaining(allergy);
        return restaurants.stream()
                .map(RestaurantDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDto> findRestaurantsByZipcode(String zipcode) {
        List<Restaurant> restaurants = restaurantRepository.findByZipcode(zipcode);
        return restaurants.stream()
                .map(RestaurantDto::new)
                .collect(Collectors.toList());
    }
}