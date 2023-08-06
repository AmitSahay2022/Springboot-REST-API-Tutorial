package com.you.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.you.tutorial.model.Emp;

public interface EMP_Repo extends JpaRepository<Emp, Integer> {
	
	List<Emp> findByDepName(String name);

}
