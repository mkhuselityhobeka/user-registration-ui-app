package com.funda.high.FundaRegistration.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class StudentRegistrationDTO {

	
	private int id;
	

	@NotBlank(message = "name cannot be empty")
	private String sName;
	@NotBlank(message = "password cannot be empty")
	private String password;
	
	

	
	@NotBlank(message = "slastName cannot be emty")
	private String slastName;
	
	@NotBlank(message = "username cannot be empty")
	private String username;



	
	
	

	
}
