package com.funda.high.FundaRegistration.service;

import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class UserRegistrationServiceImplTest {

    @MockBean
    UserRegistrationServiceImpl userRegistrationService;
    @MockBean
    UserRegistrationDTO userRegistrationDTO;

    @Test
    void enqueUserDetails() {

        userRegistrationDTO.setSname ("");
        userRegistrationDTO.setSlastName ("");
        
        userRegistrationDTO.setUsername ("mkhuselityhobeka@gmail.com");
        userRegistrationDTO.setPassword ("mkhuselityhobeka@gmail.com");


    }

    @Test
    void isup() {
    }
}
