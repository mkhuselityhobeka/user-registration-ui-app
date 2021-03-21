package com.funda.high.FundaRegistration.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString@EqualsAndHashCode
@AllArgsConstructor@NoArgsConstructor
public class ErrorHandlerDTO {
      
	  private String timestamp;
      private String status;
      private String error;
      private String meesage;
      private String trace;
      
}
