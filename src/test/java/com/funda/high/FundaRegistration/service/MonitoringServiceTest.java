package com.funda.high.FundaRegistration.service;

import com.funda.high.FundaRegistration.config.JmsConfig;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MonitoringServiceTest {

    @Autowired
    MonitoringService monitoringService;

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
    void isUp() {
        boolean isJmsUp = monitoringService.isUp();
        Assertions.assertEquals(true,isJmsUp);
    }

    @Test
    void numberOfPendingJobs() {
        int pendingJobs = 3;
        int counter = monitoringService.numberOfPendingJobs (JmsConfig.userRegQName);
        Assertions.assertEquals (pendingJobs,counter);
    }
}
