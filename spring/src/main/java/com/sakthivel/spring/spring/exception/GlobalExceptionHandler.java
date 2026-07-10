package com.sakthivel.spring.spring.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleAccountNotFound(AccountNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleValidationError(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult().getFieldErrors()
	        .stream()
	        .map(error -> error.getField() + ": " + error.getDefaultMessage())
	        .collect(Collectors.joining(", "));
	}
	
}
