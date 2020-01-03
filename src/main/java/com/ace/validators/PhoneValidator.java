package com.ace.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private boolean nullable;

	private boolean empty;

	@Override
	public void initialize(Phone phone) {

		this.nullable = phone.nullable();
		this.empty = phone.empty();
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		if (phone == null && nullable == true) {
			return true;
		}
		if (phone != null && StringUtils.isEmpty(phone) && empty == true) {
			return true;
		}
		if (phone != null && !StringUtils.isBlank(phone) && StringUtils.isNumeric(phone) && phone.length() == 10) {
			return true;
		}
		return false;
	}

}
