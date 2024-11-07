package org.squidmin.java.spring.springbootmigrationsandbox.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.squidmin.java.spring.springbootmigrationsandbox.models.User;
import org.squidmin.java.spring.springbootmigrationsandbox.services.UserService;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
//@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void testGetAllUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");

        Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/getAllUsers"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].username", is("user1")))
            .andExpect(jsonPath("$[1].username", is("user2")));
    }

    @Test
    @WithMockUser
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("user1");
        user.setPassword("password1");
        user.setEmail("user1@example.com");

        Mockito.when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/getUserById/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("user1")))
            .andExpect(jsonPath("$.email", is("user1@example.com")));
    }

    @Test
    @WithMockUser
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("newuser");
        user.setPassword("newpassword");
        user.setEmail("newuser@example.com");

        Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        String userJson = "{\"username\":\"newuser\",\"password\":\"newpassword\",\"email\":\"newuser@example.com\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("newuser")))
            .andExpect(jsonPath("$.email", is("newuser@example.com")));
    }

    @Test
    @WithMockUser
    public void testDeleteUser() throws Exception {
        Mockito.doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/deleteUser/1"))
            .andExpect(status().isOk());

        Mockito.verify(userService, Mockito.times(1)).deleteUser(1L);
    }

}
