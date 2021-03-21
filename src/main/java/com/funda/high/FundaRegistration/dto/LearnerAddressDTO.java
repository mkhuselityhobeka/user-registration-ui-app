package com.funda.high.FundaRegistration.dto;



import lombok.Data;

@Data
public class LearnerAddressDTO {

	private String houseNumber;
	private String streetName; 
	private String town; 
	private String city; 
	private String postalCode; 
	private LearnerDTO learnerModel;
}