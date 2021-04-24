package com.funda.high.FundaRegistration.service;

import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import org.apache.activemq.broker.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;


@SpringBootTest
class UserRegistrationServiceImplTest {

    @Autowired
    UserRegistrationServiceImpl userRegistrationService;

    @Autowired
    UserRegistrationDTO userRegistrationDTO;


    @Test
    void enqueUserDetails() {

        userRegistrationDTO.setSname ("Mkhuseli");
        userRegistrationDTO.setPassword ("Mkhuseli@tyhobeka88");
        userRegistrationDTO.setSlastName ("Tyhobeka");
        userRegistrationDTO.setUsername ("mkhuselityhobeka@gmail.com");
        UserRegistrationDTO registrationDTO = userRegistrationService.enqueUserDetails(userRegistrationDTO);
        Assertions.assertEquals (userRegistrationDTO,registrationDTO);


    }

    @Test
    void isUp() {
        boolean isJmsUp = userRegistrationService.isUp();
        Assertions.assertEquals (true,isJmsUp);
    }
}
