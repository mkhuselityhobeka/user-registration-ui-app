package com.funda.high.FundaRegistration.custormEmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.funda.high.FundaRegistration.validatorInterface.ValidEmail;



/*
 Email validator class
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private Pattern pattern;
	private Matcher matcher;
	
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		
		return validateEmail(username);
	}
	
	/*
	 validating email
	 */
    public boolean validateEmail(String username) {
    	pattern = Pattern.compile(EMAIL_PATTERN);
    	matcher = pattern.matcher(username);
    	return matcher.matches();
    }
  

}
