package com.funda.high.FundaRegistration.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.funda.high.FundaRegistration.validatorInterface.ValidEmail;
import com.funda.high.FundaRegistration.validatorInterface.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UserRegistrationDTO {

	
	private int id;
	

	@NotBlank(message = "name cannot be empty")
	@NotNull
	private String sName;
	
	@NotBlank(message = "password cannot be empty")
	@NotNull
	@ValidPassword
	private String password;
	
	@NotBlank(message = "slastName cannot be emty")
	@NotNull
	private String slastName;
	
	@NotBlank(message = "username cannot be empty")
	@NotNull
	@ValidEmail(message = "invalid email")
	private String username;



	
	
	

	
}
