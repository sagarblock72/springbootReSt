package com.example.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;
import com.example.repo.EmployeeRepository;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmp(Employee emp) {
		return repo.save(emp);
	}
	
	public List<Employee> getEmps(){
		return repo.findAll();
	}
	
	public Employee getById(Long id) {
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent())
			return emp.get();
		else
			return new Employee(88, "mama", "dada", "nahi");
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
		
	}
	
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> emp1=repo.findById(emp.getId());
		if(emp1.isPresent()) {
			Employee newEmp=emp1.get();
			BeanUtils.copyProperties(emp,newEmp);
			return repo.save(newEmp);
		}else {
			return repo.save(emp);
		}
	}

}
