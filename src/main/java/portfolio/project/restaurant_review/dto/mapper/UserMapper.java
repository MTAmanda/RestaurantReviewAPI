package portfolio.project.restaurant_review.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import portfolio.project.restaurant_review.dto.UserDto;
import portfolio.project.restaurant_review.model.User;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserDto toDto(User user);
    @Mapping(target ="id", ignore = true)
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> userList);
    List<User> toentityList(List<UserDto> userDto);


}
