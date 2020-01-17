package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.EmployeeDAO;
import com.example.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	public Employee saveEmployee(Employee emp) {
		return dao.saveEmp(emp);
	}
	
	public List<Employee> getall(){
		return dao.getEmps();
	}
	
	public Employee getitsById(Long id) {
		return dao.getById(id);
	}
	
	public void deleteRecord(Long id) {
		dao.deleteById(id);
	}
	
	public Employee updateData(Employee emp) {
		return dao.updateEmployee(emp);
	}

}
