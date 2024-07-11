package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.User;
import portfolio.project.restaurant_review.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllUsers();
    Optional<UserDTO> findByDisplayName(String displayName);
    UserDTO registerUser(UserDTO userDTO);
    UserDTO updateUser(String displayName, UserDTO userDTO);
    void deleteUser(String displayName);



}
