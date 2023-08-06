package com.you.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.you.tutorial.model.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
		name="Demo REST API",
		description = "to demonstrate the use of @PathVariable, @RequestBody, etc"
	)

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	//http://localhost:8080/demo/amit
	//http://localhost:8080/demo/sumit
	
	@Operation(
			 summary = "Get name form the user ",
			 description = "something about method"
			)
	@ApiResponse(
			   responseCode = "201",
			   description = "HTTP status 201 created"
			)
	
	@GetMapping("{name}")
	public ResponseEntity<String> getName(@PathVariable String name){ 
		return new ResponseEntity<>(name,HttpStatus.ACCEPTED);
	}
	
	//To use this method we need to send request like this
	//http://localhost:8080/demo/address?city=Patna&zipcode=800026
	@GetMapping("/address")
	public ResponseEntity<String> getAddress(@RequestParam String city,
			              @RequestParam String zipcode){
		String address=city+" "+zipcode;
		return new ResponseEntity<String>(address,HttpStatus.OK);
	} 
	@PostMapping
	public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
	}
	//--------------------------Reading value from property file---------
	@Value("${name1}")
	String fname;
	@Value("${name2}")
	String sname;
	@GetMapping("/show")
	public String show() {
		return fname+" "+sname;
	}

}
