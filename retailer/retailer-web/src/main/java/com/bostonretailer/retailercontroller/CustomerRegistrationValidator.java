/**
 * 
 */
package com.bostonretailer.retailercontroller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bostonretailer.retailercommon.Customer;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class CustomerRegistrationValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class aClass) {
		return Customer.class.equals(aClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		// Customer customer = (Customer) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first",
				"error.required.first");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last",
				"error.required.last");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"error.required.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"error.required.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"error.required.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"error.required.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1",
				"error.required.address1");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2",
				"error.required.address2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
				"error.required.city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
				"error.required.country");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip",
				"error.required.zip");

	}

}
