package com.ace.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ace.dto.request.PersonRequest;
import com.ace.dto.request.UpdateMobileRequest;

public interface PersonService {

	ResponseEntity<Object> savePerson(@RequestBody PersonRequest request);
	ResponseEntity<Object> getPersons();
	ResponseEntity<Object> updatePersonMobile(UpdateMobileRequest request);
}
