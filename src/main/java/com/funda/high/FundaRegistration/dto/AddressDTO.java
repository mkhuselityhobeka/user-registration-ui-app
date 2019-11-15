package com.funda.high.FundaRegistration.dto;



public class AddressDTO {
	
	private Long id;
	
	private String street_name;
	
	private String city;
	
	private String zip_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", street_name=" + street_name + ", city=" + city + ", zip_code=" + zip_code
				+ "]";
	}

	

}
