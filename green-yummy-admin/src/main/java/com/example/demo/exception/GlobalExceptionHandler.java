
package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SessionNotFoundException.class)
	public void handleSessionNotFound(SessionNotFoundException ex) {
		logger.error("Session not found: {}", ex.getMessage());
		
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public void handleUsernameNotFoundException(UsernameNotFoundException ex) {
		logger.error("Username not found: {}", ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public void handleGlobalException(Exception ex) {
		logger.error("An unexpected error occurred: {}", ex.getMessage());
	}
}
