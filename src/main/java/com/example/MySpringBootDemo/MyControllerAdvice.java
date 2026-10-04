package com.example.MySpringBootDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(CustomError.class)
	public ResponseEntity<?> myerror(CustomError err){
		CustomErrorDTO errdto = new CustomErrorDTO();
		errdto.setStatus(err.getStatus());
		errdto.setMsg(err.getMessage());
		return ResponseEntity.status(HttpStatus.valueOf(err.getStatus())).body(errdto);
		
		
		
	}
}
