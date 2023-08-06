package com.you.tutorial.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.you.tutorial.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   //Custom finder methods
	List<Employee> findByName(String name);
	
	List<Employee> findByRole(String role);
	
	//SELECT * FROM EMPLOYEE WHERE NAME=? AND ROLE=?
	List<Employee> findByNameAndRole(String name,String role);
	
	//SELECT * FROM TABLE WHERE NAME LIKE "%amit%"
	List<Employee> findByNameContaining(String keyword);
	
	
}
