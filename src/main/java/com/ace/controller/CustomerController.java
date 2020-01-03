package com.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ace.Repository.CustomerRepository;
import com.ace.dto.entity.Customer;
import com.ace.dto.request.CustomerRequest;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.service.CustomerService;
import com.ace.wrapper.CustomerWrapper;

@RequestMapping("person/")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// save customer
	@RequestMapping(value = "/save/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCustomer(@Validated @RequestBody CustomerRequest request,
			@PathVariable("user_id") String userId) {

		return customerService.saveCustomer(request, Integer.parseInt(userId));
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
