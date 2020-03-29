package com.funda.high.FundaRegistration.controller;

import javax.validation.Valid;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentApplicationController {

	private JmsTemplate jmsTemplate;
	
	public StudentApplicationController(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	

	@PostMapping("student/application")
	public UserRegistrationDTO sendStudentApplicationData(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO ) {
		
		jmsTemplate.convertAndSend("STUDENT_APPLICATION_QUEUE", userRegistrationDTO);
		
		System.out.println("Application data sent ======================" + userRegistrationDTO + "=======================================" );
	
		return userRegistrationDTO;
	}
	
	
}
