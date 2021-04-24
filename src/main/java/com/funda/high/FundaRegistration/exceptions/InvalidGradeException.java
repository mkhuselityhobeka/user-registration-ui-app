package com.funda.high.FundaRegistration.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidGradeException extends RuntimeException {
	        private static final long serialVersionUID = 1L;
	        public InvalidGradeException(String message){
	        	super(message);
			}

}
