package portfolio.project.restaurant_review.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import portfolio.project.restaurant_review.dto.RestaurantDto;
import portfolio.project.restaurant_review.model.Restaurant;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto toDto(Restaurant restaurant);
   // @Mapping(target = "id", ignore = true)
    Restaurant toEntity(RestaurantDto restaurantDto);

    List<RestaurantDto> toDtoList(List<Restaurant> restaurantList);
    List<Restaurant> toEntityList(List<RestaurantDto> restaurantDtos);
}