package com.ace.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.ace.Aspect.LogExecutionTime;
import com.ace.Aspect.LogRequestAndResponseBody;
import com.ace.dto.request.CustomerRequest;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.service.CustomerService;
import com.ace.validators.Phone;
import com.ace.validators.PhoneValidator;

import io.leangen.geantyref.TypeFactory;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@RequestMapping("customer/")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	// save customer
	@RequestMapping(value = "/save/{user_id}", method = RequestMethod.POST)
	@LogRequestAndResponseBody
	@LogExecutionTime
	public ResponseEntity<Object> saveCustomer(@Validated @RequestBody CustomerRequest request,
			@PathVariable("user_id") String userId) {
		
		ResponseEntity<Object> response = customerService.saveCustomer(request, Integer.parseInt(userId));
		return response;

	}

	// get customer list
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@LogRequestAndResponseBody
	@LogExecutionTime
	public ResponseEntity<Object> getCustomers() {

		return customerService.getCustomers();
	}

	// update customer mobile
	@RequestMapping(value = "/update/mobile/{user_id}", method = RequestMethod.POST)
	@LogRequestAndResponseBody
	@LogExecutionTime
	public ResponseEntity<Object> updateCustomerMobile(@RequestBody UpdateMobileRequest request,@PathVariable("user_id") String userId) {

		return customerService.updateCustomerMobile(request,Integer.parseInt(userId));
	}
	 
}
