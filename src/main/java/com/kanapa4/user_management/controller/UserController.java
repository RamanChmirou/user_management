package com.kanapa4.user_management.controller;

import com.kanapa4.user_management.model.ChangePasswordCommand;
import com.kanapa4.user_management.model.User;
import com.kanapa4.user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User findByEmail(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PatchMapping("{id}/password")
    public void changePassword(@PathVariable long id, @RequestBody ChangePasswordCommand password) {
        userService.changePassword(id, password.getPassword());
    }
}
