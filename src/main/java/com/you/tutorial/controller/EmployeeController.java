package com.you.tutorial.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.you.tutorial.model.Employee;
import com.you.tutorial.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@Tag(
		name="Employee REST API",
		description = "these REST API is for creating, updating,deleating employee record"
	)

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Operation(
			 summary = "API to create employee object/recourse in database ",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "201",
			   description = "HTTP status 201 created"
			)

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.ACCEPTED);
	}


	@Operation(
			 summary = "API to get employee object/recourse by id ",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "200",
			   description = "HTTP status 200 OK"
			)

	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employeeById = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}
	
	@Operation(
			 summary = "API to find all employee object/recourse from DB",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "200",
			   description = "HTTP status 200 OK"
			)
	
    @GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(
			              required = false,defaultValue = "0") int pageNum,
			              @RequestParam(required = false,defaultValue = "5") int pageSize
			) {
		List<Employee> allEmployee = employeeService.getAllEmployee(pageNum,pageSize,0);
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}
    @PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee,id);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.ACCEPTED);
	}
    
    @Operation(
			 summary = "API to delete employee object/recourse in database ",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "200",
			   description = "HTTP status 200 ok"
			)
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
    	String deleteEmployee = employeeService.deleteEmployee(id);
    	return new ResponseEntity<String>(deleteEmployee,HttpStatus.ACCEPTED);
    }
    
    //Find Employee by name and role
    
    @Operation(
			 summary = "API to find by name all employee object/recourse from database ",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "200",
			   description = "HTTP status 201 OK"
			)
    
    @GetMapping("/find-by-name")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
    	List<Employee> findByName = employeeService.findByName(name);
    	return new ResponseEntity<List<Employee>>(findByName,HttpStatus.OK);
    }
    @GetMapping("/find-by-role")
    public ResponseEntity<List<Employee>> getEmployeeByRole(@RequestParam String role){
       List<Employee> findByRole = employeeService.findByRole(role);	
       return new ResponseEntity<List<Employee>>(findByRole,HttpStatus.OK);
    }
    @GetMapping("/find-by-name-role")
    public ResponseEntity<List<Employee>> getEmpByNameAndRole(@RequestParam String name,@RequestParam String role){
       List<Employee> findByNameAndRole = employeeService.findByNameAndRole(name, role);	
       return new ResponseEntity<List<Employee>>(findByNameAndRole,HttpStatus.OK);
    }
    @GetMapping("/find-by-name-contains")
    public ResponseEntity<List<Employee>> getEmpByNameContains(@RequestParam String keyword){
    	return new ResponseEntity<List<Employee>>(employeeService.findByNameContains(keyword),HttpStatus.OK);
    }
    @GetMapping("/page")
    public ResponseEntity<List<Employee>> getAllEmployeesPagenationImplemented(
    		    @RequestParam int pageNumber,
    		    @RequestParam int pageSize
    		){
    	return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(pageNumber, pageSize),HttpStatus.OK);
    }
    
   

}
