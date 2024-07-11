package portfolio.project.restaurant_review.controller;
import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.dto.UserDto;
import portfolio.project.restaurant_review.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{displayName}")
    public Optional<UserDto> findUserById(@PathVariable("displayName") String displayName) {
        return userService.findByDisplayName(displayName);
    }

    @PostMapping
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PutMapping("/{displayName}")
    public UserDto updateUser(@PathVariable("displayName") String displayName, @RequestBody UserDto userDto) {
        return userService.updateUser(displayName, userDto);
    }

    @DeleteMapping("/{displayName}")
    public void deleteUser(@PathVariable("displayName") String displayName) {
        userService.deleteUser(displayName);
    }
}