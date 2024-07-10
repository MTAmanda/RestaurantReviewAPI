package portfolio.project.restaurant_review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.model.Restaurant;
import portfolio.project.restaurant_review.model.RestaurantDTO;
import portfolio.project.restaurant_review.service.RestaurantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDTO> findAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable("id") Long id) {
        Optional<RestaurantDTO> restaurantOptional = restaurantService.findById(id);
        return restaurantOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RestaurantDTO saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.saveRestaurant(restaurantDTO);
    }

    @PutMapping("/{id}")
    public RestaurantDTO updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDTO restaurantDTO) {
        restaurantDTO.setId(id);
        return restaurantService.updateRestaurant(restaurantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/by-allergy")
    public List<RestaurantDTO> getRestaurantsByAllergy(@RequestParam Allergies allergy) {
        return restaurantService.findRestaurantsByAllergy(allergy);
    }

    @GetMapping("/by-zipcode")
    public List<RestaurantDTO> getRestaurantsByZipcode(@RequestParam String zipcode) {
        return restaurantService.findRestaurantsByZipcode(zipcode);
    }
}