package com.ace.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface Phone {

	String message() default "{phone.invalid}";

	boolean nullable() default true;

	boolean empty() default true;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
