package portfolio.project.restaurant_review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.dto.RestaurantDto;
import portfolio.project.restaurant_review.model.Allergies;
import portfolio.project.restaurant_review.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDto> findAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findRestaurantById(@PathVariable("id") Long id) {
        RestaurantDto restaurantDto = restaurantService.findById(id);
        return ResponseEntity.ok(restaurantDto);
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto savedRestaurant = restaurantService.createRestaurant(restaurantDto);
        return ResponseEntity.ok(savedRestaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto updatedRestaurant = restaurantService.updateRestaurant(restaurantDto);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-allergy")
    public List<RestaurantDto> getRestaurantsByAllergy(@RequestParam Allergies allergy) {
        return restaurantService.findRestaurantsByAllergy(allergy);
    }

    @GetMapping("/by-zipcode")
    public List<RestaurantDto> getRestaurantsByZipcode(@RequestParam String zipcode) {
        return restaurantService.findRestaurantsByZipcode(zipcode);
    }
}
