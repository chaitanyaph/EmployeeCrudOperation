package com.micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entity.Employee;
import com.micro.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	public Employee createEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}
	
	public List<Employee> getAllEmployee(){
		
		return empRepo.findAll();
	}
	
	public Optional<Employee> getEmployee(Integer empId) {
		
		return empRepo.findById(empId);
	}
	
	public String updateEmployee(Integer empId, Employee employee) {
	    Optional<Employee> findById = empRepo.findById(empId);

	    if (findById.isPresent()) {
	        Employee existingEmployee = findById.get();
	        
	        existingEmployee.setEmpName(employee.getEmpName());
	        existingEmployee.setEmail(employee.getEmail());
	        existingEmployee.setCity(employee.getCity());
	        existingEmployee.setPhnNo(employee.getPhnNo());
	        existingEmployee.setEmpDesignation(employee.getEmpDesignation());
	        existingEmployee.setEmpSalary(employee.getEmpSalary());
	        
	        empRepo.save(existingEmployee);
	        
	        return "Employee Data Successfully Updated";
	    } else {
	        return "Employee is not present";
	    }
	}

	
	public String deleteEmployee(Integer empId) {
		
		Optional<Employee> findById = empRepo.findById(empId);
		
		if(findById.isPresent()) {
			
			empRepo.deleteById(empId);
			return "Employee Deleted Successfully";
		}
		return "Employee Not Found";
	}
}
