package com.carmona.springboot.springbootapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmona.springboot.springbootapi.dao.PersonRepository;
import com.carmona.springboot.springbootapi.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public Person findPersonById(int theId) {
		// optional allow us to check if person is present without checking for nulls
		Optional<Person> person = personRepository.findById(theId);
		
		Person thePerson = null;
		
		if (person.isPresent()) {
			thePerson = person.get();
		} else {
			throw new RuntimeException("The Employee Id could not be found : " + theId);
		}
		
		return thePerson;
	}

}
