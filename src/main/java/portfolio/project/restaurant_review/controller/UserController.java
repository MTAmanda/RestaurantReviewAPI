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

    @GetMapping("/{Id}")
    public Optional<User> findUserById(@PathVariable("Id") Long Id){
        return userService.findById(Id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{Id}")
    public User user(@PathVariable("Id") Long Id, @RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{Id}")
    public void deleteUser(@PathVariable("Id") Long Id){
        userService.deleteUser(Id);
    }
}
