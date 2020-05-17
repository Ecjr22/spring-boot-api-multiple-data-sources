package com.carmona.springboot.springbootapi.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmona.springboot.springbootapi.dao.EmployeeRepository;
import com.carmona.springboot.springbootapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final static Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int theId) {
		
		// optional allow us to check if employee is present without checking for nulls
		Optional<Employee> employee = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (employee.isPresent()) {
			theEmployee = employee.get();
		} else {
			LOGGER.log(Level.INFO, "The Employee Id could not be found : " + theId);
			throw new RuntimeException("The Employee Id could not be found : " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		// just in case they pass in an id in JSON, we set it to 0
		// this is to force a save of a new item rather than an update
		theEmployee.setId(0);
		
		employeeRepository.saveAndFlush(theEmployee);
	}
	
	@Override
	public void updateEmployee(Employee theEmployee) {
		
		employeeRepository.saveAndFlush(theEmployee);
	}

	@Override
	public void deleteEmployeeById(int theId) {
		
		// check if the id / employee exists before deleting it
		Employee tempEmployee = findEmployeeById(theId);
		
		if (tempEmployee == null) {
			LOGGER.log(Level.INFO, "The Employee Id not found : " + theId);
			throw new RuntimeException("The Employee Id not found : " + theId);
		}
		
		employeeRepository.deleteById(theId);
	}

}
