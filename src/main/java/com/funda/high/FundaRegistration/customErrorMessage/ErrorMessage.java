package com.funda.high.FundaRegistration.customErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private Date timeStmp;
    private String message;
    private String description;

}
