package portfolio.project.restaurant_review.service;

import org.springframework.dao.DataIntegrityViolationException;
import portfolio.project.restaurant_review.model.User;
import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.model.UserDTO;
import portfolio.project.restaurant_review.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName)
                .map(UserDTO::new);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findByDisplayName(userDTO.getDisplayName());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists, please choose a different username");
        }
        User user = convertToEntity(userDTO);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error saving user: " + e.getMessage(), e);
        }

        return convertToDTO(user);
    }

    @Override
    public UserDTO updateUser(String displayName, UserDTO userDTO) {
        Optional<User> oldUserOptional = userRepository.findByDisplayName(displayName);
        if (!oldUserOptional.isPresent()) {
            throw new RuntimeException("No User was found by the provided Username");
        }
        User oldUser = oldUserOptional.get();

        oldUser.setInterestedInPeanutAllergy(userDTO.isInterestedInPeanutAllergy());
        oldUser.setInterestedInEggAllergy(userDTO.isInterestedInEggAllergy());
        oldUser.setInterestedInDairyAllergy(userDTO.isInterestedInDairyAllergy());

        return convertToDTO(userRepository.save(oldUser));
    }

    @Override
    public void deleteUser(String displayName) {
        userRepository.deleteUserByDisplayName(displayName);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setDisplayName(user.getDisplayName());
        userDTO.setInterestedInPeanutAllergy(user.isInterestedInPeanutAllergy());
        userDTO.setInterestedInEggAllergy(user.isInterestedInEggAllergy());
        userDTO.setInterestedInDairyAllergy(user.isInterestedInDairyAllergy());
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setDisplayName(userDTO.getDisplayName());
        user.setInterestedInPeanutAllergy(userDTO.isInterestedInPeanutAllergy());
        user.setInterestedInEggAllergy(userDTO.isInterestedInEggAllergy());
        user.setInterestedInDairyAllergy(userDTO.isInterestedInDairyAllergy());
        return user;
    }
}