package portfolio.project.restaurant_review.controller;

import portfolio.project.restaurant_review.model.User;
import org.springframework.web.bind.annotation.*;
import portfolio.project.restaurant_review.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

}
