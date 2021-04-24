package com.funda.high.FundaRegistration.service;

import com.funda.high.FundaRegistration.config.JmsConfig;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRegistrationServiceImplTest {

    @Autowired
    UserRegistrationServiceImpl userRegistrationService;

    @Autowired
    UserRegistrationDTO userRegistrationDTO;

    @BeforeEach
    void setUp(){

        userRegistrationDTO.setSname ("Mkhuseli");
        userRegistrationDTO.setPassword("Mkhuseli@tyhobeka88");
        userRegistrationDTO.setSlastName("Tyhobeka");
        userRegistrationDTO.setUsername("mkhuselityhobeka@gmail.com");
    }

    @Test
    void enqueUserDetails() {
        UserRegistrationDTO registrationDTO = userRegistrationService.enqueUserDetails(userRegistrationDTO);
        Assertions.assertEquals (userRegistrationDTO,registrationDTO);
    }

    @Test
    void isUp() {
        boolean isJmsUp = userRegistrationService.isUp();
        Assertions.assertEquals(true,isJmsUp);
    }

    @Test
    void isPasswordValid() {
        boolean isPasswordValid = userRegistrationService.isPasswordValid (userRegistrationDTO.getPassword());
        Assertions.assertTrue (isPasswordValid);
    }

    @Test
    void numberOfPendingJobs() {
            int pendingJobs = 3;
            int counter = userRegistrationService.numberOfPendingJobs (JmsConfig.userRegQName);
            Assertions.assertEquals (pendingJobs,counter);
    }


}
