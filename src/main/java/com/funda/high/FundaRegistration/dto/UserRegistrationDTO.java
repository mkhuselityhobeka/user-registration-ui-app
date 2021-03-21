package com.funda.high.FundaRegistration.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Component
public class UserRegistrationDTO {

	
	private int id;
	@NotBlank(message = "name cannot be empty")
	@NotNull
	private String sname;
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
	
	private boolean enabled;

	private Collection<RolesDTO> roles = new ArrayList<RolesDTO>();

}
