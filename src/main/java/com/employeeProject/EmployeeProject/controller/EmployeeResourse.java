package com.employeeProject.EmployeeProject.controller;

import java.util.List;

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

import com.employeeProject.EmployeeProject.model.Employee;
import com.employeeProject.EmployeeProject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResourse {
	
	private final EmployeeService employeeService;
	
	public EmployeeResourse(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		System.out.println("hey");
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> getEmployeeById(@RequestBody Employee employee){
		Employee newemployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newemployee,HttpStatus.CREATED);
	
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateemployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateemployee,HttpStatus.CREATED);
	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	
	}
	
	
}
