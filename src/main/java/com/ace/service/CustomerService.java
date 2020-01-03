package com.ace.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ace.dto.request.CustomerRequest;
import com.ace.dto.request.UpdateMobileRequest;

public interface CustomerService {

	ResponseEntity<Object> saveCustomer( CustomerRequest request,int userId);
	ResponseEntity<Object> getCustomers();
	ResponseEntity<Object> updateCustomerMobile(UpdateMobileRequest request);
}
