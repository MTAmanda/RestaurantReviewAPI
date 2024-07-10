package portfolio.project.restaurant_review.controller;
import portfolio.project.restaurant_review.model.User;
import org.springframework.web.bind.annotation.*;
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
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{displayName}")
    public Optional<User> findUserById(@PathVariable("displayName") String displayName){
        return userService.findByDisplayName(displayName);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{displayName}")
    public User user(@PathVariable("displayname") String displayName, @RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{displayName}")
    public void deleteUser(@PathVariable("displayName") String displayName){
        userService.deleteUser(displayName);
    }
}
