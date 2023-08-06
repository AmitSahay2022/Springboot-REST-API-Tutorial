package com.you.tutorial.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> argumentNotValid(MethodArgumentNotValidException e){
		Map<String,Object> error=new HashMap<>();
		error.put("timestamp", System.currentTimeMillis());
		
		List<String> err=e.getBindingResult()
				          .getFieldErrors()
				          .stream()
				          .map(x->x.getDefaultMessage())
				          .toList();
		
		error.put("Message", err);
		return new ResponseEntity<Map<String,Object>>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<Map<String,Object>> notFound(ResourseNotFoundException e){
		Map<String,Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("timestamp", System.currentTimeMillis());
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}

}
