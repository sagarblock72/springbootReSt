package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Employee;
import com.example.repo.EmployeeRepository;
import com.example.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWithRestAndMockitoApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@Mock
	private EmployeeRepository repo;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getallTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Employee(12,"saga","dada","gsgsgg"),new Employee(13,"donda","dada","gsgsgg")).collect(Collectors.toList()));
		assertEquals(2, service.getall().size());
	}
	
	/*
	 * @Test public void getitsById() { long n;
	 * when(repo.findById(n)).thenReturn(new Employee(54, "sds", "dssd", "sdf")); }
	 */
	
	@Test
	public void updateEmployeeTest() {
		Employee emp=new Employee(15, "edf", "rere", "rrer");
		Employee emp1=new Employee(15, "edf", "rere", "rrer");
		when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp, service.saveEmployee(emp));
	}
	

}
