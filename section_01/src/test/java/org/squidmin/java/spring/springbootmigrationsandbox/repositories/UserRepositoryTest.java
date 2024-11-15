package org.squidmin.java.spring.springbootmigrationsandbox.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    public void testSaveUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setEmail("testuser@example.com");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindUserById() {
        User user = new User();
        user.setUsername("findme");
        user.setPassword("password456");
        user.setEmail("findme@example.com");
        User savedUser = userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(savedUser.getId());

        Assertions.assertThat(foundUser).isPresent();
        Assertions.assertThat(foundUser.get().getUsername()).isEqualTo("findme");
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("updateme");
        user.setPassword("password789");
        user.setEmail("updateme@example.com");
        User savedUser = userRepository.save(user);

        savedUser.setEmail("updated@example.com");
        User updatedUser = userRepository.save(savedUser);

        Assertions.assertThat(updatedUser.getEmail()).isEqualTo("updated@example.com");
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setUsername("deleteme");
        user.setPassword("password000");
        user.setEmail("deleteme@example.com");
        User savedUser = userRepository.save(user);

        userRepository.deleteById(savedUser.getId());

        Optional<User> deletedUser = userRepository.findById(savedUser.getId());
        Assertions.assertThat(deletedUser).isNotPresent();
    }

}
