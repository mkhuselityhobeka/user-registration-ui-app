package com.funda.high.FundaRegistration.validatorInterface;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.funda.high.FundaRegistration.custormemaivalidator.EmailValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE, FIELD, ANNOTATION_TYPE}) 
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
	
	String message() default"Invalid Email";
	Class<?> [] groups () default {};
	Class<? extends Payload>[] payload() default {};


}
