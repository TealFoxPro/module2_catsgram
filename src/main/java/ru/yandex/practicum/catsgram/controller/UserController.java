package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{email}")
    public User findUser(@PathVariable("email") String email) {
        return userService.GetUserByEmail(email);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User put(@RequestBody User user) {
        return userService.updUser(user);
    }
}