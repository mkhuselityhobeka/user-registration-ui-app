package com.funda.high.FundaRegistration.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funda.high.FundaRegistration.dto.StudentRegistrationDTO;
import com.funda.high.FundaRegistration.model.StudentRegistration;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRegistrationController {
	
	private static final Logger LOGGER =
		      LoggerFactory.getLogger(StudentRegistration.class);

	@Autowired
	JmsTemplate jmsTemplate;
	
	@PostMapping("student/registration")
	public void sendMessage(@RequestBody StudentRegistrationDTO studentRegistration) {
		System.out.println("studentRegistration is =====================================" + studentRegistration);
		jmsTemplate.convertAndSend("USER_REGISTRATION", studentRegistration);
		LOGGER.info("add message to queue ", studentRegistration);
	
		
	
	}

}
