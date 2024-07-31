package com.micro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entity.Employee;
import com.micro.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp){
		
		Employee createEmployee = empService.createEmployee(emp);
		return new ResponseEntity<Employee>(createEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmp(){
		
		List<Employee> allEmployee = empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Optional<Employee>> GetEmployee(@PathVariable Integer empId){
		
		Optional<Employee> employee = empService.getEmployee(empId);
		return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmp(@PathVariable Integer empId,  @RequestBody Employee emp){
		
		String updateEmployee = empService.updateEmployee(empId, emp);
		return new ResponseEntity<String>(updateEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer empId){
		
		String deleteEmployee = empService.deleteEmployee(empId);
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
	}

}
