package com.funda.high.FundaRegistration.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RolesDTO {
	
	private Long id;
	private String roleAuthority;
	private UserRegistrationDTO registration;

}
