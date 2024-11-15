package org.squidmin.java.spring.springbootmigrationsandbox.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;
import org.squidmin.java.spring.springbootmigrationsandbox.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        when(userService.createUser(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);
        Assertions.assertNotNull(createdUser);
    }

    @Test
    void createUser_shouldSaveUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isEqualTo(1L);
        assertThat(savedUser.getUsername()).isEqualTo("testUser");
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void getAllUsers_shouldReturnAllUsers() {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("testUser_1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("testUser_2");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertThat(users).isNotNull();
        assertThat(users).hasSize(2);
        assertThat(users.get(0).getUsername()).isEqualTo("testUser_1");
        assertThat(users.get(1).getUsername()).isEqualTo("testUser_2");
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserById_shouldReturnUser_whenUserExists() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(1L);
        assertThat(foundUser.getUsername()).isEqualTo("testUser");
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserById_shouldReturnNull_whenUserDoesNotExist() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        User foundUser = userService.getUserById(1L);

        assertThat(foundUser).isNull();
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void deleteUser_shouldDeleteUser_whenUserExists() {
        Long userId = 1L;

        doNothing().when(userRepository).deleteById(anyLong());

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

}
