package portfolio.project.restaurant_review.service;

import org.springframework.dao.DataIntegrityViolationException;
import portfolio.project.restaurant_review.model.User;
import org.springframework.stereotype.Service;
import portfolio.project.restaurant_review.dto.UserDto;
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
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName)
                .map(UserDto::new);
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByDisplayName(userDto.getDisplayName());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists, please choose a different username");
        }
        User user = convertToEntity(userDto);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error saving user: " + e.getMessage(), e);
        }

        return convertToDto(user);
    }

    @Override
    public UserDto updateUser(String displayName, UserDto userDto) {
        Optional<User> oldUserOptional = userRepository.findByDisplayName(displayName);
        if (!oldUserOptional.isPresent()) {
            throw new RuntimeException("No User was found by the provided Username");
        }
        User oldUser = oldUserOptional.get();

        oldUser.setInterestedInPeanutAllergy(userDto.isInterestedInPeanutAllergy());
        oldUser.setInterestedInEggAllergy(userDto.isInterestedInEggAllergy());
        oldUser.setInterestedInDairyAllergy(userDto.isInterestedInDairyAllergy());

        return convertToDto(userRepository.save(oldUser));
    }

    @Override
    public void deleteUser(String displayName) {
        userRepository.deleteUserByDisplayName(displayName);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setDisplayName(user.getDisplayName());
        userDto.setInterestedInPeanutAllergy(user.isInterestedInPeanutAllergy());
        userDto.setInterestedInEggAllergy(user.isInterestedInEggAllergy());
        userDto.setInterestedInDairyAllergy(user.isInterestedInDairyAllergy());
        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setDisplayName(userDto.getDisplayName());
        user.setInterestedInPeanutAllergy(userDto.isInterestedInPeanutAllergy());
        user.setInterestedInEggAllergy(userDto.isInterestedInEggAllergy());
        user.setInterestedInDairyAllergy(userDto.isInterestedInDairyAllergy());
        return user;
    }
}