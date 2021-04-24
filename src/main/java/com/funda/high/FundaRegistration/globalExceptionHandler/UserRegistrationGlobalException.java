package com.funda.high.FundaRegistration.globalExceptionHandler;

import com.funda.high.FundaRegistration.customErrorMessage.ErrorMessage;
import com.funda.high.FundaRegistration.exceptions.InvalidPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@ControllerAdvice
public class UserRegistrationGlobalException {

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<?> invalidPasswordExceptionHandler(InvalidPasswordException invaldPasswordException, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage (new Date(), invaldPasswordException.getMessage(),request.getDescription (false));
         return new ResponseEntity<> (errorMessage, HttpStatus.BAD_REQUEST);
    }
}
