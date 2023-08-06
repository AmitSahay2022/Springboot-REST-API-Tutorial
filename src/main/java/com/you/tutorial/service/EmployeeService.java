package com.you.tutorial.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.you.tutorial.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);

	String deleteEmployee(int id);

	Employee updateEmployee(Employee e,int id);

	Employee getEmployeeById(int id);
/*These method is to learn Pagenation*/
	List<Employee> getAllEmployee(int p,int s,int x); //Only for fun to learn no use of x here
	
	List<Employee> getAllEmployee(int pageNumber,int pageSize);
	
	
	
	List<Employee> findByName(String name);
	
	List<Employee> findByRole(String role);
	
	List<Employee> findByNameAndRole(String name,String role);
	
	List<Employee> findByNameContains(String kayword);
	
	
}
