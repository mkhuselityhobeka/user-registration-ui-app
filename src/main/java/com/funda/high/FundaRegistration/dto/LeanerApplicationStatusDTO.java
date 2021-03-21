package com.funda.high.FundaRegistration.dto;



import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LeanerApplicationStatusDTO {

	private int gradeApplyingFor;
	private int currentGrade;
	private String applicationStatus ;
	private byte[] applicantReport;
	private LearnerDTO learnerModel;
}
