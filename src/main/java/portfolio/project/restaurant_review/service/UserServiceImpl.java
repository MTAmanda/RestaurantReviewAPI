package portfolio.project.restaurant_review.service;

import portfolio.project.restaurant_review.model.User;
import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> oldUserOptional = userRepository.findByDisplayName(user.getDisplayName());
        if (!oldUserOptional.isPresent()) {
            throw new RuntimeException("No User was found by the provided Username");
        }
        User oldUser = oldUserOptional.get();

        oldUser.setInterestedInPeanutAllergy(user.isInterestedInPeanutAllergy());
        oldUser.setInterestedInEggAllergy(user.isInterestedInEggAllergy());
        oldUser.setInterestedInDairyAllergy(user.isInterestedInDairyAllergy());

        return userRepository.save(oldUser);
    }
    @Override
    public void deleteUser(String displayName) {
        userRepository.deleteUserByDisplayName(displayName);
    }
}
