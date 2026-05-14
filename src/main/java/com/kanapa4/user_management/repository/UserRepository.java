package com.kanapa4.user_management.repository;

import com.kanapa4.user_management.exception.InvalidUserException;
import com.kanapa4.user_management.exception.UserDoesNotExistsException;
import com.kanapa4.user_management.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        if (user == null) {
            throw new InvalidUserException("Invalid user");
        }
        users.add(user);
        return user;
    }

    public Optional<User> findById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User update(User user) {
        return findById(user.getId())
                .map(existingUser -> {
                    existingUser.update(user);
                    return existingUser;
                })
                .orElseThrow(() -> new UserDoesNotExistsException("User does not exists"));
    }

    public void deleteById(long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
