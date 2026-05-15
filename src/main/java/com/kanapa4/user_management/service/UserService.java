package com.kanapa4.user_management.service;

import com.kanapa4.user_management.exception.UserAlreadyExistsException;
import com.kanapa4.user_management.exception.UserDoesNotExistsException;
import com.kanapa4.user_management.model.User;
import com.kanapa4.user_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserDoesNotExistsException("User does not exists"));
    }

    public User create(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return userRepository.save(user);
    }

    public User update(long id, User user) {
        User existing = findById(id);
        existing.update(user);
        return userRepository.update(existing);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void changePassword(long id,String password) {
        User user = findById(id);
        user.setPassword(password);
    }
}
