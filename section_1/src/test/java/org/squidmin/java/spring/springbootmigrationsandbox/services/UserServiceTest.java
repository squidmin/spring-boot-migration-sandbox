package org.squidmin.java.spring.springbootmigrationsandbox.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserService mockUserService;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        Mockito.when(mockUserService.createUser(Mockito.any(User.class))).thenReturn(user);

        User createdUser = mockUserService.createUser(user);
        Assertions.assertNotNull(createdUser);
    }

}
