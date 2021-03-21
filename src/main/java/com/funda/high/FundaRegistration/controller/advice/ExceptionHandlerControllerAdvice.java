package com.funda.high.FundaRegistration.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.funda.high.FundaRegistration.exceptions.InvalidGradeException;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(value = InvalidGradeException.class)
	public ResponseEntity<Object>invalidGradeException(InvalidGradeException invalidGradeException){
		   return new ResponseEntity<Object>("current grade cannot be higher the grade applying for", HttpStatus.BAD_REQUEST);
	}
}
