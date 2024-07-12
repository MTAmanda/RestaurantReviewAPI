package portfolio.project.restaurant_review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.dto.mapper.RestaurantMapper;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.dto.RestaurantDto;
import portfolio.project.restaurant_review.repository.RestaurantRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Transactional
    @Override
    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantMapper.toDtoList(restaurantList);
    }

    @Transactional
    @Override
    public RestaurantDto findById(Long id) {
        Restaurant restaurant = restaurantRepository.getReferenceById(id);
        return restaurantMapper.toDto(restaurant);
    }

   @Transactional
    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
       Restaurant restaurant = restaurantMapper.toEntity(restaurantDto);

       Optional<Restaurant> existingRestaurant = restaurantRepository.findByNameAndZipcode(restaurantDto.getName(), restaurantDto.getZipcode());
       if (existingRestaurant.isPresent()) {
           throw new RuntimeException("Another restaurant with the same name and zipcode already exists");
       }

       Restaurant savedRestaurant = restaurantRepository.save(restaurant);
       return restaurantMapper.toDto(savedRestaurant);
   }
    @Transactional
    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurantToUpdate = restaurantRepository.getReferenceById(restaurantDto.getId());

        if (restaurantDto.getName() != null) {
            restaurantToUpdate.setName(restaurantDto.getName());
        }
        if (restaurantDto.getAddress() != null) {
            restaurantToUpdate.setAddress(restaurantDto.getAddress());
        }
        if (restaurantDto.getCity() != null) {
            restaurantToUpdate.setCity(restaurantDto.getCity());
        }
        if (restaurantDto.getState() != null) {
            restaurantToUpdate.setState(restaurantDto.getState());
        }
        if (restaurantDto.getZipcode() != null) {
            restaurantToUpdate.setZipcode(restaurantDto.getZipcode());
        }

        Restaurant updatedRestaurant = restaurantRepository.save(restaurantToUpdate);
        return restaurantMapper.toDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantDto> findRestaurantsByAllergy(Allergies allergy) {
        List<Restaurant> restaurantList = restaurantRepository.findBySupportedAllergiesContaining(allergy);
        return restaurantMapper.toDtoList(restaurantList);
    }

    @Override
    public List<RestaurantDto> findRestaurantsByZipcode(String zipcode) {
        List<Restaurant> restaurantList = restaurantRepository.findByZipcode(zipcode);
        return restaurantMapper.toDtoList(restaurantList);
    }

    @Transactional(readOnly = true)
    public List<RestaurantDto> getRestaurantsByZipcodeWithScoresOrderedByScoreCount(String zipcode) {
        List<Object[]> restaurantObjects = restaurantRepository.findRestaurantsByZipcodeWithScoresOrderedByScoreCount(zipcode);

        return restaurantObjects.stream()
                .map(object -> {
                    Restaurant restaurant = (Restaurant) object[0];
                    // You can access scoreCount as object[1] if needed
                    return restaurantMapper.toDto(restaurant);
                })
                .collect(Collectors.toList());
    }
}