package com.funda.high.FundaRegistration.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.funda.high.FundaRegistration.dto.LearnerDTO;
import com.funda.high.FundaRegistration.exceptions.InvalidGradeException;
import com.funda.high.FundaRegistration.service.LearnerService;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/funda")
@CrossOrigin("*")
public class StudentApplicationController {


	@Value("${upload.path}")
	private String path;
	@Autowired
    private LearnerService learnerService;
	@PostMapping(value ="save/learner",
			consumes = {MediaType.APPLICATION_JSON_VALUE,
						MediaType.MULTIPART_FORM_DATA_VALUE
			})
	public ResponseEntity<LearnerDTO>postLearnerData(@RequestPart("learnerDTO") String  learnerDTO, @RequestPart("file")MultipartFile file) throws InvalidGradeException{
			return new ResponseEntity<>(learnerService.saveLearner(learnerDTO,file), HttpStatus.CREATED);
	}
	

}
