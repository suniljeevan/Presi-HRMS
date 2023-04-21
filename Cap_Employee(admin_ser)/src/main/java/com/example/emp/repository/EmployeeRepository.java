package com.example.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findAll();

}
