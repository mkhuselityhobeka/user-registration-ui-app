package com.funda.high.FundaRegistration.interfaces;

import java.util.List;

import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;


public interface UserRegistrationInterface {
	
	 UserRegistrationDTO enqueUserDetails(UserRegistrationDTO userRegistrationDTO);
	 Object userLogin(UserRegistrationDTO registrationDTO);
	 List<Object>getAllUsers();
}
