package org.squidmin.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AbstractUserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(userRepository);
    }

    @Test
    void testUserSaveAndFetch() {
        User user = new User();
        user.setId(1L);
        user.setName("test user");

        userRepository.save(user);

        User fetchedUser = userRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(fetchedUser);
    }

}
