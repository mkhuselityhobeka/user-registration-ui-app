package com.funda.high.FundaRegistration.dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class LearnerDTO {

	private String name;
	private String lastName;
	private String age;
	private String dob;
	private String contactNumber;
	private String learnerID;
	private List<LearnerAddressDTO> learnerAddressModel = new ArrayList<>();
	private LeanerApplicationStatusDTO applicationStatus;
}
