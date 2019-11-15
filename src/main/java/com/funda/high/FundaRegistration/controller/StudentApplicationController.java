package com.funda.high.FundaRegistration.controller;

import javax.validation.Valid;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.funda.high.FundaRegistration.model.StudentApplication;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentApplicationController {

	private JmsTemplate jmsTemplate;
	
	public StudentApplicationController(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	

	@PostMapping("student/application")
	public void sendStudentApplicationData(@Valid @RequestBody StudentApplication studentApplicationDTO ) {
		
		jmsTemplate.convertAndSend("STUDENT_APPLICATION_QUEUE", studentApplicationDTO);
		
		System.out.println("Application data sent ======================" + studentApplicationDTO + "=======================================" );
	}
	
	
}
