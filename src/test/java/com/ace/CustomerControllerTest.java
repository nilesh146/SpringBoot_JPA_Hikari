package com.ace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ace.controller.CustomerController;
import com.ace.dto.request.CustomerRequest;
import com.ace.service.CustomerService;
import com.ace.service.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private CustomerService customerServiceImpl;
	@Test
	void saveCustomerTest() {

		Gson gson = new Gson();
		String body = gson.toJson(getCustomerRequest());
		Mockito.when(customerServiceImpl.saveCustomer(Mockito.any(), Mockito.anyInt()))
				.thenReturn(new ResponseEntity<Object>(HttpStatus.OK));
		try {
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/customer/save/4").content(body)
					.contentType("application/json").characterEncoding("utf-8")).andDo(print()).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Mockito. verify(customerServiceImpl, times(1)).saveCustomer(Mockito.any(), Mockito.anyInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
