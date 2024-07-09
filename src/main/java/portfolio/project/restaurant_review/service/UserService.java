package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    Optional<User> findById(Long id);
    User saveUser(User user);


}
