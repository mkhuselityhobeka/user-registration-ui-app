package com.funda.high.FundaRegistration.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long  id;
	private String password;

	private String sname;
	private String slastName;
	
	private String username;
	
	
   

	

}
