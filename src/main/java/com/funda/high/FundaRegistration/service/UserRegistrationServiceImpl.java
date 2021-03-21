package com.funda.high.FundaRegistration.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.funda.high.FundaRegistration.config.JmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.funda.high.FundaRegistration.dto.LoginResponseDTO;
import com.funda.high.FundaRegistration.dto.RolesDTO;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import com.funda.high.FundaRegistration.interfaces.UserRegistrationInterface;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRegistrationServiceImpl implements UserRegistrationInterface{

	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.login}")
	private String loginApi;
	@Value("${api.get.all}")
	private String getAllUsers;
	
	RolesDTO roleDTO = new RolesDTO();
	Collection<RolesDTO>collectionRoleDTO = new ArrayList<RolesDTO>();
	
	/*save user registration data to activemq*/
	@Override
	public UserRegistrationDTO enqueUserDetails(UserRegistrationDTO userRegistrationDTO){

		   log.debug("userRegistrationDTO " + userRegistrationDTO);

		   if(userRegistrationDTO.getUsername().equalsIgnoreCase("mkhuselityhobeka@gmail.com")){
			   roleDTO.setRoleAuthority("ROLE_ADMIN");
		   }else {	   
			   roleDTO.setRoleAuthority("ROLE_USER");
			}
		   collectionRoleDTO.add(roleDTO);
		   userRegistrationDTO.setRoles(collectionRoleDTO);
		   log.debug("userRegistrationDTO " + userRegistrationDTO);
  		   jmsTemplate.convertAndSend(JmsConfig.userRegQName,userRegistrationDTO);
		   return userRegistrationDTO;
	}
	
	/*call user login db service api */
	@Override
	public Object userLogin(UserRegistrationDTO registrationDTO){
		LoginResponseDTO loginResponseDTO = restTemplate.postForObject(loginApi, registrationDTO, LoginResponseDTO.class);
		if(loginResponseDTO != null) {
			return loginResponseDTO;
		}else {
			return  restTemplate.getErrorHandler();
		}
	}

	/*calling getallusers api db service api */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllUsers() {
		return restTemplate.getForObject(getAllUsers, List.class);
	}	
}
