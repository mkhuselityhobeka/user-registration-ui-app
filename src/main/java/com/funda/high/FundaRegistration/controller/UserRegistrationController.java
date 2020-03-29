package com.funda.high.FundaRegistration.controller;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;


import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserRegistrationController {
	


	@Autowired
	JmsTemplate jmsTemplate;
	
	@PostMapping("user/registration")
	public ResponseEntity<UserRegistrationDTO>sendMessage(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
		
		log.info("  is =====================================" + userRegistrationDTO);
		jmsTemplate.convertAndSend("USER_REGISTRATION", userRegistrationDTO);
		log.info("added message to queue ", userRegistrationDTO);
	
		return ResponseEntity.ok(userRegistrationDTO);
	
	}

}
