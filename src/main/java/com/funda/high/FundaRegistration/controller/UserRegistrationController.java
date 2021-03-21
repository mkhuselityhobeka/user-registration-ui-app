package com.funda.high.FundaRegistration.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import com.funda.high.FundaRegistration.service.UserRegistrationServiceImpl;



@RestController
@RequestMapping("/funda")
@CrossOrigin(origins = "*")
public class UserRegistrationController {
	
	@Autowired
	UserRegistrationServiceImpl userRegistrationServiceImpl;
		
	@PostMapping("user/registration")
	public ResponseEntity<UserRegistrationDTO>sendMessage(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {	
		   return ResponseEntity.ok(userRegistrationServiceImpl.enqueUserDetails(userRegistrationDTO));
	
	}
	
	@PostMapping("login")
	public ResponseEntity<Object> userLogin(@RequestBody UserRegistrationDTO userRegistrationDTO){
		return new ResponseEntity<>(userRegistrationServiceImpl.userLogin(userRegistrationDTO), HttpStatus.ACCEPTED);
	}

	@GetMapping("all/user")
	public ResponseEntity<List<Object>>returnUser(){
		return new ResponseEntity<>(userRegistrationServiceImpl.getAllUsers(), HttpStatus.OK);
	}
}
