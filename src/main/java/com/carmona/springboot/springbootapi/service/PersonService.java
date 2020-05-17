package com.carmona.springboot.springbootapi.service;

import com.carmona.springboot.springbootapi.entity.Person;

public interface PersonService {

	public Person findPersonById(int theId);
	
}
