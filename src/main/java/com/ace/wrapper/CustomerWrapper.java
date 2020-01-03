package com.ace.wrapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ace.dto.entity.Customer;
import com.ace.dto.request.CustomerRequest;

@Component
public class CustomerWrapper {

	public Customer fromCustomerRequest(CustomerRequest request) {
		Customer cust = new Customer();
		cust.setFirstName(request.getFirstName());
		cust.setLastName(request.getLastName());
		cust.setMiddleName(request.getMiddleName());
		cust.setMobile(request.getMobile());
		cust.setEmail(request.getEmail());
		cust.setCreateDate(new Date());
		cust.setAge(request.getAge());
		return cust;
	}

}
