package com.funda.high.FundaRegistration.dto;







public class StudentApplicationDTO {
	
	private Long id;
	
	private String first_name;
	
	private String last_name;
	
	private String pob;
	

	private String dob;
	
	private String id_number;
	
	private String home_language;
	
	private String citizenship;
	
	private String previous_school;
	
	private String reason_for_leaving;
	
	private String past_results;
	

	private AddressDTO addressDTO;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getPob() {
		return pob;
	}


	public void setPob(String pob) {
		this.pob = pob;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getId_number() {
		return id_number;
	}


	public void setId_number(String id_number) {
		this.id_number = id_number;
	}


	public String getHome_language() {
		return home_language;
	}


	public void setHome_language(String home_language) {
		this.home_language = home_language;
	}


	public String getCitizenship() {
		return citizenship;
	}


	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}


	public String getPrevious_school() {
		return previous_school;
	}


	public void setPrevious_school(String previous_school) {
		this.previous_school = previous_school;
	}


	public String getReason_for_leaving() {
		return reason_for_leaving;
	}


	public void setReason_for_leaving(String reason_for_leaving) {
		this.reason_for_leaving = reason_for_leaving;
	}


	public String getPast_results() {
		return past_results;
	}


	

	public void setPast_results(String past_results) {
		this.past_results = past_results;
	}


	public AddressDTO getAddressDTO() {
		return addressDTO;
	}


	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}


	@Override
	public String toString() {
		return "StudentApplicationDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", pob="
				+ pob + ", dob=" + dob + ", id_number=" + id_number + ", home_language=" + home_language
				+ ", citizenship=" + citizenship + ", previous_school=" + previous_school + ", reason_for_leaving="
				+ reason_for_leaving + ", past_results=" + past_results + ", addressDTO=" + addressDTO + ", getId()="
				+ getId() + ", getFirst_name()=" + getFirst_name() + ", getLast_name()=" + getLast_name()
				+ ", getPob()=" + getPob() + ", getDob()=" + getDob() + ", getId_number()=" + getId_number()
				+ ", getHome_language()=" + getHome_language() + ", getCitizenship()=" + getCitizenship()
				+ ", getPrevious_school()=" + getPrevious_school() + ", getReason_for_leaving()="
				+ getReason_for_leaving() + ", getPast_results()=" + getPast_results() + ", getAddressDTO()="
				+ getAddressDTO() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



}
