package com.ace.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ace.Repository.CustomerRepository;
import com.ace.dto.entity.Customer;
import com.ace.dto.request.CustomerRequest;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.wrapper.CustomerWrapper;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerWrapper customerWrapper;
	
	 private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	// insert new record
	@Override
	public ResponseEntity<Object> saveCustomer(CustomerRequest request, int userId) {

		Customer cust = customerWrapper.fromCustomerRequest(request);
		cust.setUserId(userId);
		
		// handle the exception occure during inserting record into the Customer_Details
		// Table.
		try {
			customerRepository.save(cust);
			logger.info("record inserted successfully into dB"+ cust.getCustId());
		} catch (Exception ex) {
			logger.error("error occur while inserting a record into DB :-" ,ex);
		
			return new ResponseEntity<Object>("error occur while inserting a record into DB", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	// get all
	@Override
	public ResponseEntity<Object> getCustomers() {
		List<Customer> persons = customerRepository.getAllPerson();
		return new ResponseEntity<Object>(persons, HttpStatus.OK);
	}

	// update mobile
	@Override
	public ResponseEntity<Object> updateCustomerMobile(UpdateMobileRequest request) {
		
		try {
			customerRepository.updateMobile(request.getCustId(), request.getMobile());
			logger.info("record updated successfully into dB"+ request.getCustId());
		} catch (Exception ex) {
			logger.error("error occur while updating a record into DB :-" ,ex);
		
			return new ResponseEntity<Object>("error occur while updating a record into DB", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}

}
