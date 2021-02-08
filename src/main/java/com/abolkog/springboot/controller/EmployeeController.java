package com.abolkog.springboot.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.abolkog.springboot.exception.ResourceNotFoundException;
import com.abolkog.springboot.model.Employee;
import com.abolkog.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("")
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)throws ResourceNotFoundException {
		
          Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found for this id:"+id));
        		  return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@PostMapping("")
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee>putEmployee(@PathVariable long id,@Valid@RequestBody Employee employeeDetails)throws ResourceNotFoundException{
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found for this id:"+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		  return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteEmployee(@PathVariable long id){
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
