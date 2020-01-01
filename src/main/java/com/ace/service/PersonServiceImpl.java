package com.ace.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ace.Repository.PersonRepository;
import com.ace.dto.entity.Person;
import com.ace.dto.request.PersonRequest;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.wrapper.PersonWrapper;

@Service

public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonWrapper personWrapper;
  //insert new record
	@Override
	public ResponseEntity<Object> savePerson( PersonRequest request) {
		Person p = personWrapper.fromPersonRequest(request);
		personRepository.save(p);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	//get all
	@Override
	public ResponseEntity<Object> getPersons() {
		List<Person> persons = personRepository.getAllPerson();
		return new ResponseEntity<Object>(persons, HttpStatus.OK);
	}

	//update mobile
	@Override
	public ResponseEntity<Object> updatePersonMobile(UpdateMobileRequest request) {
		
		personRepository.updateMobile(request.getPersonId(),request.getMobile());
		return new ResponseEntity<Object>( HttpStatus.OK);
	}

}
