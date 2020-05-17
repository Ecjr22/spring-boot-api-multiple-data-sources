package com.carmona.springboot.springbootapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carmona.springboot.springbootapi.entity.Person;
import com.carmona.springboot.springbootapi.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	@Autowired
	PersonService personService;
	
	// Get Person by Id
	@GetMapping("/persons/{personId}")
	public Person getPersonById(@PathVariable int personId) {
		
		Person person = personService.findPersonById(personId);
		
		return person;
	}
	

}
