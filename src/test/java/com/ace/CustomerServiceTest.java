package com.ace;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerWrapper customerWrapper;

	@Test
	public void saveCustomerTest() {
		List<Customer> customers = new ArrayList<Customer>();
		Mockito.when(customerWrapper.fromCustomerRequest(Mockito.any())).thenReturn(getCustomer());
		Mockito.when(customerRepository.findByuserId(Mockito.anyInt())).thenReturn(customers);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(getCustomer());
		ResponseEntity<Object> response = customerServiceImpl.saveCustomer(getCustomerRequest(), 3);
		assertEquals(200, response.getStatusCode().value());
	}
	@Test
	public void saveCustomerTest_customer_exist() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(getCustomer());
		Mockito.when(customerWrapper.fromCustomerRequest(Mockito.any())).thenReturn(getCustomer());
		Mockito.when(customerRepository.findByuserId(Mockito.anyInt())).thenReturn(customers);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(getCustomer());
		ResponseEntity<Object> response = customerServiceImpl.saveCustomer(getCustomerRequest(), 3);
		assertEquals(200, response.getStatusCode().value());
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
