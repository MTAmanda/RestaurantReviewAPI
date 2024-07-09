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
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> oldUserOptional = userRepository.findById(user.getId());
        if (!oldUserOptional.isPresent()) {
            throw new RuntimeException("No User was found");
        }
        User oldUser = oldUserOptional.get();
        if (user.getDisplayName() != null) {
            oldUser.setDisplayName(user.getDisplayName());
        }
        oldUser.setInterestedInPeanutAllergy(user.isInterestedInPeanutAllergy());
        oldUser.setInterestedInEggAllergy(user.isInterestedInEggAllergy());
        oldUser.setInterestedInDairyAllergy(user.isInterestedInDairyAllergy());

        return userRepository.save(oldUser);
    }
    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }
}
