package portfolio.project.restaurant_review.controller;
import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.model.UserDTO;
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
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{displayName}")
    public Optional<UserDTO> findUserById(@PathVariable("displayName") String displayName) {
        return userService.findByDisplayName(displayName);
    }

    @PostMapping
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PutMapping("/{displayName}")
    public UserDTO updateUser(@PathVariable("displayName") String displayName, @RequestBody UserDTO userDTO) {
        return userService.updateUser(displayName, userDTO);
    }

    @DeleteMapping("/{displayName}")
    public void deleteUser(@PathVariable("displayName") String displayName) {
        userService.deleteUser(displayName);
    }
}