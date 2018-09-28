package com.suvha.libraryManagmentSystemMysql.exceptionHandler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.suvha.libraryManagmentSystemMysql.exception.DataNotFoundException;
import com.suvha.libraryManagmentSystemMysql.model.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DataNotFoundException.class)
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorMessage> DataNotFound(DataNotFoundException ex, HttpServletRequest request){
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(ex.getMessage());
		error.setDetail(request.getRequestURI());
		error.setTimestamp(new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@Override
	@ResponseBody
	public  ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header,HttpStatus status, WebRequest request){
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage("Validation Error");
		error.setTimestamp(new Date());
		error.setDetail(ex.getBindingResult().toString());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
