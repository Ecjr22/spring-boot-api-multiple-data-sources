package com.carmona.springboot.springbootapi.service;

import com.carmona.springboot.springbootapi.db2entity.Customer;

public interface CustomerService {

	public Customer findCustomerById(int theId);
}
