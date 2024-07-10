package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findByDisplayName(String displayName);
    User saveUser(User user);
    User updateUser (User user);
    void deleteUser(String displayName);



}
