package com.funda.high.FundaRegistration.validatorInterface;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.funda.high.FundaRegistration.custormemaivalidator.PasswordValid;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValid.class)
public @interface ValidPassword {
	
	String message() default"Invalid password";
	Class<?> [] groups () default {};
	Class<? extends Payload>[] payload() default {};

}
