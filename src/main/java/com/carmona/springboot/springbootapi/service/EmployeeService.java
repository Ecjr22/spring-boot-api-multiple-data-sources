package com.carmona.springboot.springbootapi.service;

import java.util.List;

import com.carmona.springboot.springbootapi.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployees();
	
	public Employee findEmployeeById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void updateEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);

}
