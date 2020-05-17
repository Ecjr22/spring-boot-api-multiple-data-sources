package com.carmona.springboot.springbootapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carmona.springboot.springbootapi.entity.Employee;
import com.carmona.springboot.springbootapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	// Get Mapping for returning a list of all employees
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}
	
	// Get Mapping for returning a Employee by Id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findEmployeeById(employeeId);
		
		return employee;
	}
	
	// POST / create an employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return employee;
	}
	
	// PUT / update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.updateEmployee(employee);
		
		return employee;
	}
	
	// DELETE / delete an employee by Id
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		employeeService.deleteEmployeeById(employeeId);
		
		return "Deleted Employee id : " + employeeId;
	}
}
