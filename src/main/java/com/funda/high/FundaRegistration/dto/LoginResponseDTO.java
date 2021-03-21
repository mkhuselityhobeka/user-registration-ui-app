package com.funda.high.FundaRegistration.dto;

import java.util.Collection;

public class LoginResponseDTO {

	private Long id;
	private String token;
	private String type = "Bearer";
	private String username;
	private Collection<RolesDTO> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<RolesDTO> getRoles() {
		return roles;
	}
	public void setRoles(Collection<RolesDTO> roles) {
		this.roles = roles;
	}
	
	
}
