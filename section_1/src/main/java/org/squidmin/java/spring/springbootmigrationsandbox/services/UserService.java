package org.squidmin.java.spring.springbootmigrationsandbox.services;

import org.springframework.stereotype.Service;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;
import org.squidmin.java.spring.springbootmigrationsandbox.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
