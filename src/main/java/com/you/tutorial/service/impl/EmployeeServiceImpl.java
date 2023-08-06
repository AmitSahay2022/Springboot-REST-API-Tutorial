package com.you.tutorial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.you.tutorial.exception.ResourseNotFoundException;
import com.you.tutorial.model.Employee;
import com.you.tutorial.repository.EmployeeRepository;
import com.you.tutorial.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub

		return employeeRepository.save(e);
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Employee not found with id: " + id));
		employeeRepository.delete(employee);
		return "Employee with id: " + id + " is deleted";
	}

	@Override
	public Employee updateEmployee(Employee e, int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(
						() -> new ResourseNotFoundException(
								"Employee not found with id: " + id));
		
		
		employee.setName(e.getName());
		employee.setRole(e.getRole());
		employee.setSalary(e.getSalary());

		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElseThrow(
				()->new ResourseNotFoundException(
						"Employee not found with id: "+id));
employeeRepository.delete(employee);;
		return employee;
	}

	@Override
	/*
	 * implemented Pageable
	 */
	public List<Employee> getAllEmployee(int page, int size, int just_Joking) {
		// TODO Auto-generated method stub
		Pageable p = PageRequest.of(page, size);

		return employeeRepository.findAll(p).toList();
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub

		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByRole(String role) {
		// TODO Auto-generated method stub
		return employeeRepository.findByRole(role);
	}

	@Override
	public List<Employee> findByNameAndRole(String name, String role) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNameAndRole(name, role);
	}

	@Override
	public List<Employee> findByNameContains(String kayword) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNameContaining(kayword);
	}

	@Override
	// Implemented Pageable hera also
	public List<Employee> getAllEmployee(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pages = PageRequest.of(pageNumber, pageSize);
		List<Employee> content = employeeRepository.findAll(pages).getContent();
		return content;
	}

}
