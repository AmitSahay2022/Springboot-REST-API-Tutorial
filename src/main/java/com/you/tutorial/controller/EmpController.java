package com.you.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.you.tutorial.model.Emp;
import com.you.tutorial.repository.EMP_Repo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
    private EMP_Repo emp_Repo;
	
	
	
	@PostMapping
	public ResponseEntity<Emp> create(@RequestBody Emp emp){
		Emp save = emp_Repo.save(emp);
		return new ResponseEntity<Emp>(save,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		emp_Repo.deleteById(id);
		return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping
	public List<Emp> getAll(){
		List<Emp> findAll = emp_Repo.findAll();
		return findAll;
	}
	@GetMapping("/depname")
	public ResponseEntity<List<Emp>> findByDep(@RequestParam String depName){
		return new ResponseEntity<List<Emp>>(emp_Repo.findByDepName(depName),HttpStatus.OK);
	}
}
