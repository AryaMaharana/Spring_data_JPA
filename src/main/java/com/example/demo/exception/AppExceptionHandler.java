package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleAnyExceptionEntity(BusinessException e) {

		Map<String, Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("errorCode", e.getErrorCode());

		return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
