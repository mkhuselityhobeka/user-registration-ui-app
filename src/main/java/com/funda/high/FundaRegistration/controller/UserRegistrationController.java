package com.funda.high.FundaRegistration.controller;


import java.util.List;
import javax.validation.Valid;
import com.funda.high.FundaRegistration.config.JmsConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import com.funda.high.FundaRegistration.service.UserRegistrationServiceImpl;



@RestController
@RequestMapping("/funda/v1")
@CrossOrigin(origins = "*")
public class UserRegistrationController {
	
	UserRegistrationServiceImpl userRegistrationServiceImpl;
	public UserRegistrationController(UserRegistrationServiceImpl userRegistrationServiceImpl){
		   this.userRegistrationServiceImpl = userRegistrationServiceImpl;
	}
		
	@PostMapping(value = "user/registration", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
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
