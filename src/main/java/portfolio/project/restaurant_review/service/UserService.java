package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAllUsers();
    Optional<UserDto> findByDisplayName(String displayName);
    UserDto registerUser(UserDto userDto);
    UserDto updateUser(String displayName, UserDto userDto);
    void deleteUser(String displayName);



}
