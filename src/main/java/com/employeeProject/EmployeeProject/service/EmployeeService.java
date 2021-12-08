package com.employeeProject.EmployeeProject.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeProject.EmployeeProject.exception.UserNotFoundException;
import com.employeeProject.EmployeeProject.model.Employee;
import com.employeeProject.EmployeeProject.repo.EmployeeRepo;

@Service
public class EmployeeService {
	public final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee); 
		
	}
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id" +id+"was not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
	

}
