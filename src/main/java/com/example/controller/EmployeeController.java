package com.example.controller;

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

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/hello")
	public String getMessage() {
		return "hello sagar";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
		return ResponseEntity.ok().body(service.saveEmployee(emp));
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return service.getall();
	}
	
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable("id") Long id) {
		return service.getitsById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deletebyEmpId(@PathVariable("id") Long id) {
		service.deleteRecord(id);
		return HttpStatus.FORBIDDEN;
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmps(@PathVariable("id") Long id,@RequestBody Employee emp) {
		emp.setId(id);
		return service.updateData(emp);
	}

}
