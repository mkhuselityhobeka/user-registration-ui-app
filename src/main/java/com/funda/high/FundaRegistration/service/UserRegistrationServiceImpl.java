package com.funda.high.FundaRegistration.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.funda.high.FundaRegistration.config.JmsConfig;
import com.funda.high.FundaRegistration.exceptions.InvalidPasswordException;
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

	private String password;

	public UserRegistrationServiceImpl (JmsTemplate jmsTemplate, RestTemplate restTemplate){
		this.jmsTemplate = jmsTemplate;
		this.restTemplate = restTemplate;
	}

	/*save user registration data to activemq*/
	/*make method synchronized so it can be accessed by one thread at time*/
	@Override
	public synchronized UserRegistrationDTO enqueUserDetails(UserRegistrationDTO userRegistrationDTO) throws InvalidPasswordException {

		        log.info("sending message='{}' to destination='{}'",userRegistrationDTO,JmsConfig.userRegQName);
			    setRoleAuthorities(userRegistrationDTO.getUsername());
			    userRegistrationDTO.setRoles(collectionRoleDTO);
				if (isPasswordValid(userRegistrationDTO.getPassword())){
					jmsTemplate.convertAndSend(JmsConfig.userRegQName,userRegistrationDTO);
					return userRegistrationDTO;
				}else{
					throw new InvalidPasswordException ("Password must contain atleast 1 uppercase, atleast 1 special character and atleast 1 digit");
				}
	}

	/*set Authority based on username provided*/
	public RolesDTO setRoleAuthorities(String username){

		if(username.equalsIgnoreCase("mkhuselityhobeka@gmail.com")){
			roleDTO.setRoleAuthority("ROLE_ADMIN");
		}else{
			roleDTO.setRoleAuthority("ROLE_USER");
		}
		collectionRoleDTO.add(roleDTO);
		return roleDTO;
	}

	/*check if provided password matches the provided regex rules*/
	public boolean isPasswordValid(String password){
		this.password = password;
		String passwordRegexRules = "^(?=.*[0-8])(?=.*[a-z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile (passwordRegexRules);
		Matcher matcher  = pattern.matcher(password);
		return matcher.matches();
	}


	/*check the message sent*/
	@Override
	public void onMessage(Message message) {
		if(message instanceof ActiveMQTextMessage){
			ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
			try{
				log.debug ("Busy processing message " + activeMQTextMessage.getText());
				Thread.sleep (5000);
				log.debug ("Completed  processing message " + activeMQTextMessage.getText());
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
