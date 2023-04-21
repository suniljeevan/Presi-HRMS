package com.example.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.exception.ResourceNotFoundException;
import com.example.emp.model.Employee;
import com.example.emp.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController 
{
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	//Get All Employees Rest API
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		logger.debug("Sucessfully you featched all the Employee details");
		System.out.println();
		
		return employeeRepository.findAll();
	}
	//Create Employee by Rest API
	@PostMapping
	public Employee createNewEmployee(@RequestBody Employee employee) 
	{
		logger.debug("New Employee added sucessfully");
		System.out.println();
		
		return employeeRepository.save(employee);
	}
	//Get Employee by ID Rest API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable long id)
	{
		logger.debug("Sucessfully you got the Employee details by id");
		System.out.println();
		
		Employee employee= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:"+id));
		return ResponseEntity.ok(employee);
		
	}
	//Update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
	{
		logger.debug("Sucessfully you updated the Employee details");
		System.out.println();
		
		Employee updateEmployee= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:"+id));
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setGender(employeeDetails.getGender());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		updateEmployee.setPhoneNum(employeeDetails.getPhoneNum());
		updateEmployee.setDOB(employeeDetails.getDOB());
		updateEmployee.setFatherName(employeeDetails.getFatherName());
		updateEmployee.setMotherName(employeeDetails.getMotherName());
		updateEmployee.setBloodGroup(employeeDetails.getBloodGroup());
		updateEmployee.setAddress(employeeDetails.getAddress());
		
		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
		
	}
	//Delete Employee Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
	{
		logger.debug("Employee has been deleted sucessfuly");
		System.out.println();
		
		Employee employee= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:"+id));
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
