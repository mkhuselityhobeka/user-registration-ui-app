package com.funda.high.FundaRegistration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserRegistrationControllerTest{

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    UserRegistrationDTO userRegistrationDTO;

    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setup(){
        userRegistrationDTO.setSname ("Mkhuseli");
        userRegistrationDTO.setPassword("Mkhuseli@tyhobeka88");
        userRegistrationDTO.setSlastName("Tyhobeka");
        userRegistrationDTO.setUsername("mkhuselityhobeka@gmail.com");
    }

    @Test
    void sendMessage() throws Exception{

        String url ="/funda/v1/user/registration";

        ObjectMapper objectMapper = new ObjectMapper ();
        String userRegistration = objectMapper.writeValueAsString (userRegistrationDTO);
        String requestMessage = userRegistration;
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content (requestMessage)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
