package com.ace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ace.Repository.CustomerRepository;
import com.ace.dto.entity.Customer;
import com.ace.dto.request.CustomerRequest;
import com.ace.service.CustomerServiceImpl;
import com.ace.wrapper.CustomerWrapper;

//junit runner 5 support by springRunner
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	//mocking
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerWrapper customerWrapper;

	@Test
	public void saveCustomerTest() {
		//stub
		List<Customer> customers = new ArrayList<Customer>();
		//stubbing
		Mockito.when(customerWrapper.fromCustomerRequest(Mockito.any(CustomerRequest.class))).thenReturn(getCustomer());
		Mockito.when(customerRepository.findByuserId(Mockito.anyInt())).thenReturn(customers);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(getCustomer());
		//calling actual method which we have to test
		ResponseEntity<Object> response = customerServiceImpl.saveCustomer(getCustomerRequest(), 3);
		//assertion
		assertEquals(200, response.getStatusCode().value());
		//verification
		Mockito. verify(customerWrapper, times(1)).fromCustomerRequest(Mockito.any(CustomerRequest.class));
		Mockito. verify(customerRepository, times(1)).findByuserId(Mockito.anyInt());
		Mockito. verify(customerRepository, times(1)).save(Mockito.any(Customer.class));
		
	}
	@Test
	public void saveCustomerTest_customer_exist() {
		//stub
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(getCustomer());
		//stubbing
		Mockito.when(customerWrapper.fromCustomerRequest(Mockito.any())).thenReturn(getCustomer());
		Mockito.when(customerRepository.findByuserId(Mockito.anyInt())).thenReturn(customers);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(getCustomer());
		//calling actual method which we have to test
		ResponseEntity<Object> response = customerServiceImpl.saveCustomer(getCustomerRequest(), 3);
		//assertion
		assertEquals(200, response.getStatusCode().value());
		//verification
		Mockito. verify(customerWrapper, times(1)).fromCustomerRequest(Mockito.any(CustomerRequest.class));
		Mockito. verify(customerRepository, times(1)).findByuserId(Mockito.anyInt());
		Mockito. verify(customerRepository, times(0)).save(Mockito.any(Customer.class));
	}

	public CustomerRequest getCustomerRequest() {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setFirstName("anil");
		customerRequest.setLastName("singh");
		customerRequest.setMiddleName("ashish");
		customerRequest.setAge(20);
		customerRequest.setMobile("6767565434");
		customerRequest.setEmail("anil@gmail.com");
		return customerRequest;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("anil");
		customer.setLastName("singh");
		customer.setMiddleName("ashish");
		customer.setUserId(3);
		customer.setMobile("6767565434");
		customer.setEmail("anil@gmail.com");
		customer.setExpireDate(null);
		customer.setCreateDate(new Date());
		return customer;
	}
}
