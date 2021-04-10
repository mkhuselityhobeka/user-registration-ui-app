package com.funda.high.FundaRegistration.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.funda.high.FundaRegistration.config.JmsConfig;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.funda.high.FundaRegistration.dto.LoginResponseDTO;
import com.funda.high.FundaRegistration.dto.RolesDTO;
import com.funda.high.FundaRegistration.dto.UserRegistrationDTO;
import com.funda.high.FundaRegistration.interfaces.UserRegistrationInterface;
import lombok.extern.slf4j.Slf4j;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Service
@Slf4j
public class UserRegistrationServiceImpl implements UserRegistrationInterface, MessageListener {

	@Value("${api.login}")
	private String loginApi;
	@Value("${api.get.all}")
	private String getAllUsers;

	RolesDTO roleDTO = new RolesDTO();
	Collection<RolesDTO>collectionRoleDTO = new ArrayList<>();

	JmsTemplate jmsTemplate;
	RestTemplate restTemplate;
	int counter = 0;
	public UserRegistrationServiceImpl (JmsTemplate jmsTemplate, RestTemplate restTemplate){
		this.jmsTemplate = jmsTemplate;
		this.restTemplate = restTemplate;
	}



	/*save user registration data to activemq*/
	@Override
	public UserRegistrationDTO enqueUserDetails(UserRegistrationDTO userRegistrationDTO){

		   log.debug ("sending message='{}' to destination='{}'",userRegistrationDTO,JmsConfig.userRegQName);
		   if(userRegistrationDTO.getUsername().equalsIgnoreCase("mkhuselityhobeka@gmail.com")){
			   roleDTO.setRoleAuthority("ROLE_ADMIN");
		   }else {	   
			   roleDTO.setRoleAuthority("ROLE_USER");
			}
		   collectionRoleDTO.add(roleDTO);
		   userRegistrationDTO.setRoles(collectionRoleDTO);
  		   jmsTemplate.convertAndSend(JmsConfig.userRegQName,userRegistrationDTO);
		   return userRegistrationDTO;
	}

	/*get pending jobs from user_regitration*/
	public int numberOfPendingJobs(String registrationQueue){
		return jmsTemplate.browse (registrationQueue,((session, browser) ->
				                    Collections.list (browser.getEnumeration ()).size ()));
	}

    /*get pending jobs from user_regitration*/
	public int numberOfProcessedMessages(){
		return counter;
	}
	/*check activeMQ connection status*/
	public boolean isup(){
		ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory ();
        try{
			connectionFactory.createConnection();
			return  true;
		}catch (Exception exception){
        	exception.printStackTrace ();
		}
		return  false;
	}
	/*check the message sent*/
	@Override
	public void onMessage(Message message) {
		if(message instanceof ActiveMQTextMessage){
			ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
			try{
				log.info ("Busy processing message " + activeMQTextMessage.getText());
				Thread.sleep (5000);
				log.info ("Completed  processing message " + activeMQTextMessage.getText());
			}catch (InterruptedException interruptedException){
				interruptedException.printStackTrace ();

			}catch (JmsException | JMSException jmsException){
				jmsException.printStackTrace ();
			}
		}else{
			log.error ("The message is not a text message");
		}
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
