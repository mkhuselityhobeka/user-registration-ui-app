package com.funda.high.FundaRegistration.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.funda.high.FundaRegistration.dto.LearnerDTO;
import com.funda.high.FundaRegistration.exceptions.InvalidGradeException;

public interface LearnerInterface {
	public LearnerDTO saveLearner(String learnerDTO, MultipartFile file) throws InvalidGradeException;

}
