package portfolio.project.restaurant_review.dto.mapper;

import org.mapstruct.Mapper;
import portfolio.project.restaurant_review.dto.RestaurantDto;
import portfolio.project.restaurant_review.model.Restaurant;

@Mapper
public interface RestaurantMapper {
    RestaurantDto map(Restaurant restaurant);
    Restaurant map(RestaurantDto restaurantDto);
}