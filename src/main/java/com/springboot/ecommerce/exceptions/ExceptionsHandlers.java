package com.springboot.ecommerce.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionsHandlers {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Map<String,String> handleException(Exception ex){
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NullPointerException.class)
	public Map<String,String> handleNullException(NullPointerException ex){
		Map<String, String> error = new HashMap<>();
		error.put("error", "Not found");
		return error;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DuplicateKeyException.class)
	public Map<String, String> handleDuplicateKeyExceptions(DuplicateKeyException ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("error", "Duplicate Key");
		return error;
	}
	
	
}
