package com.carmona.springboot.springbootapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmona.springboot.springbootapi.db2dao.CustomerRepository;
import com.carmona.springboot.springbootapi.db2entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer findCustomerById(int theId) {
		// optional allow us to check if customer is present without checking for nulls
		Optional<Customer> customer = customerRepository.findById(theId);
		
		Customer theCustomer = null;
		
		if (customer.isPresent()) {
			theCustomer = customer.get();
		} else {
			throw new RuntimeException("The Employee Id could not be found : " + theId);
		}
		
		return theCustomer;
	}

}
