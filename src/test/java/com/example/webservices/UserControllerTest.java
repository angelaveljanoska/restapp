package com.example.webservices;

import com.example.webservices.model.User;
import com.example.webservices.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void shouldBeAbleToRegisterAndLogin() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user/register").contentType(MediaType.APPLICATION_JSON).content(
                        writer.writeValueAsString(
                                new UserDto("user1", "pass", "pass")
                        )
                )
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result ->
                        mockMvc.perform(
                                MockMvcRequestBuilders.post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(
                                        writer.writeValueAsString(
                                                new User("user1", "pass")
                                        )
                                )
                        ).andExpect(MockMvcResultMatchers.status().isOk())
                );
    }

    @Test
    public void shouldBeAbleToRegisterAndUnregister() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user/register").contentType(MediaType.APPLICATION_JSON).content(
                        writer.writeValueAsString(
                                new UserDto("user", "pass", "pass")
                        )
                )
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> MockMvcRequestBuilders.delete("/api/user").contentType(MediaType.APPLICATION_JSON).content(
                        writer.writeValueAsString(
                                new UserDto("user", "pass", "pass")
                        )
                )).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
