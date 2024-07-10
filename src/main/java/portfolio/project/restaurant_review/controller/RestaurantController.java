package portfolio.project.restaurant_review.controller;

import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.model.Restaurant;
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
    public List<Restaurant> findAllRestaurants(){
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("/{Id}")
    public Optional<Restaurant> findRestaurantById(@PathVariable("Id") Long Id){
        return restaurantService.findById(Id);
    }

    @PostMapping
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.saveRestaurant(restaurant);
    }

    @PutMapping("/{Id}")
    public Restaurant restaurant(@PathVariable("Id") Long Id, @RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/{Id}")
    public void deleteRestaurant(@PathVariable("Id") Long Id){
        restaurantService.deleteRestaurant(Id);
    }
}
