package com.funda.high.FundaRegistration.custormemaivalidator;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.AlphabeticalSequenceRule;
import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.NumericalSequenceRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.QwertySequenceRule;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;
import org.passay.PasswordValidator;
import com.funda.high.FundaRegistration.validatorInterface.ValidPassword;
import com.google.common.base.Joiner;

public class PasswordValid implements ConstraintValidator<ValidPassword, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		 
		final PasswordValidator validator = new PasswordValidator(Arrays.asList(
		           
				    new LengthRule(8, 30), 
		            new UppercaseCharacterRule(1), 
		            new DigitCharacterRule(1), 
		            new SpecialCharacterRule(1) 
		           ));
		        
		final RuleResult result = validator.validate(new PasswordData(password));
		if(result.isValid()) {
			return true;
		}
				context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate(
		          Joiner.on(",").join(validator.getMessages(result)))
		          .addConstraintViolation();
		       
		        return false;
	
	}

	
}
