package com.ace.runner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URI;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ace.dto.request.CustomerRequest;
import com.google.gson.Gson;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class CucumberStepDefination {

private final String SERVER_URL = "http://localhost:8080/customer/save/2";
private final String THINGS_ENDPOINT = "/things";

private RestTemplate restTemplate;

private CustomerRequest customerRequest;

private ResponseEntity<HttpStatus> responseEntity;

@Given("^customer details$")
public void customer_details() throws Throwable {
   
   
}

@When("^the client calls /version \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_client_calls_version_and_and_and_and_and(String firstName, String lastName, String middleName, String age, String mobile, String email) throws Throwable {
	  customerRequest= getCustomerRequest( firstName, lastName, middleName, age,  mobile,  email);
		restTemplate = new RestTemplate();
	  responseEntity = restTemplate.postForEntity(SERVER_URL, 	  customerRequest, HttpStatus.class);
		/*
		 * RequestEntity request = RequestEntity .post(new URI(SERVER_URL))
		 * .accept(MediaType.APPLICATION_JSON) .body(customerRequest);
		 */
    	  //responseEntity = restTemplate.exchange(request, Object.class);
    	 
  
}

@Then("^the client receives status code of \"([^\"]*)\"$")
public void the_client_receives_status_code_of(String httpStatus) throws Throwable {
	System.out.println("hello");
	assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
	//assertEquals(responseEntity.getStatusCode(), Integer.parseInt(httpStatus));
   
}
 public CustomerRequest getCustomerRequest(String firstName, String lastName, String middleName, String age, String mobile, String email) {
	 CustomerRequest customerRequest= new CustomerRequest();
	 customerRequest.setFirstName(firstName);
	 customerRequest.setLastName(lastName);
	 customerRequest.setMiddleName(middleName);
	 customerRequest.setAge(Integer.parseInt(age));
	 customerRequest.setMobile(mobile);
	 customerRequest.setEmail(email);
	 return customerRequest;
 }

}
