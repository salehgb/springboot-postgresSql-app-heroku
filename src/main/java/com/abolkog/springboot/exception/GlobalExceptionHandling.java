package com.abolkog.springboot.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        
        ErrorDetails error = new ErrorDetails(new Date() , ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
       
      
        ErrorDetails error = new ErrorDetails(new Date() , ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
