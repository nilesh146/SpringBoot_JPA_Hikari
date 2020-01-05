package com.ace.controller;

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

@RequestMapping("person/")
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
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomers() {

		return customerService.getCustomers();
	}

	// update customer mobile
	@RequestMapping(value = "/update/mobile", method = RequestMethod.POST)
	public ResponseEntity<Object> updateCustomerMobile(@RequestBody UpdateMobileRequest request) {

		return customerService.updateCustomerMobile(request);
	}

}
