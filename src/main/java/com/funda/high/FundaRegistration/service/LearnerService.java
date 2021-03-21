package com.funda.high.FundaRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.funda.high.FundaRegistration.dto.LeanerApplicationStatusDTO;
import com.funda.high.FundaRegistration.dto.LearnerDTO;
import com.funda.high.FundaRegistration.exceptions.InvalidGradeException;
import com.funda.high.FundaRegistration.interfaces.LearnerInterface;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LearnerService implements LearnerInterface{

	
	   @Autowired
	   JmsTemplate jmsTemplate;

	   ObjectMapper objectMapper = new ObjectMapper();
	   LearnerDTO learnerDTO = new LearnerDTO();
	   LeanerApplicationStatusDTO leanerApplicationStatusDTO;

		@Override
		public LearnerDTO saveLearner(String  learner, MultipartFile file) throws InvalidGradeException {
			try {
				
				learnerDTO = objectMapper.readValue(learner, LearnerDTO.class);
			    leanerApplicationStatusDTO = learnerDTO.getApplicationStatus();
				leanerApplicationStatusDTO.setApplicantReport(file.getBytes());
				learnerDTO.setApplicationStatus(leanerApplicationStatusDTO);
			}catch (Exception exception) {
				     log.error(exception.getMessage());
				}
		
			if(learnerDTO.getApplicationStatus().getCurrentGrade() > learnerDTO.getApplicationStatus().getGradeApplyingFor()) {
				throw new InvalidGradeException();
			}else {
				jmsTemplate.convertAndSend("Learner_Application",learnerDTO);
		    	log.info("Learner application data has been saved");
				return learnerDTO;
			}
			
		}
}
