package com.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ace.Repository.PersonRepository;
import com.ace.dto.entity.Person;
import com.ace.dto.request.PersonRequest;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.service.PersonService;
import com.ace.wrapper.PersonWrapper;

@RequestMapping("person/")
@RestController
public class PersonController {

	@Autowired
	private PersonService PersonService;
  //save person
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Object> savePerson( @Validated @RequestBody PersonRequest request) {

		return PersonService.savePerson(request);
	}
   //get person list
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<Object> getPersons() {

		return PersonService.getPersons();
	}

	//update person mobile
	@RequestMapping(value = "/update/mobile", method = RequestMethod.POST)
	public ResponseEntity<Object> updatePersonMobile(@RequestBody UpdateMobileRequest request) {

		return PersonService.updatePersonMobile(request);
	}

}
