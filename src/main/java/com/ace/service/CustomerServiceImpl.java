package com.ace.service;

import java.util.List;

import javax.validation.Valid;

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

	// insert new record
	@Override
	public ResponseEntity<Object> saveCustomer(CustomerRequest request, int userId) {

		Customer cust = customerWrapper.fromCustomerRequest(request);
		cust.setUserId(userId);
		// handle the exception occure during inserting record into the Customer_Details
		// Table.
		try {
			customerRepository.save(cust);
		} catch (Exception ex) {
			System.out.println("error occur while inserting a record into DB :-" + ex);
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
		customerRepository.updateMobile(request.getCustId(), request.getMobile());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
