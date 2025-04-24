package com.example.department.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.department.entity.ErrorDetails;
import com.example.department.exception.InValidInputException;
import com.example.department.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFoundExceptioin(NotFoundException ex, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InValidInputException.class)
	public ResponseEntity<ErrorDetails> handleInValidException(InValidInputException inputException, WebRequest webRequest){
		
		ErrorDetails errDetails = new ErrorDetails(new Date(), inputException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errDetails,HttpStatus.BAD_REQUEST);
	}
		
	}


