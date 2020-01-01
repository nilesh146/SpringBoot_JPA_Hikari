package com.ace.wrapper;

import org.springframework.stereotype.Component;

import com.ace.dto.entity.Person;
import com.ace.dto.request.PersonRequest;
@Component
public class PersonWrapper {

	public Person fromPersonRequest(PersonRequest request) {
		Person p = new Person();
		
		p.setFirstName(request.getFirstName());
		p.setLastName(request.getLastName());
		p.setMobile(request.getMobile());
		p.setEmail(request.getEmail());
		p.setAge(request.getAge());
		return p;
	}

}
