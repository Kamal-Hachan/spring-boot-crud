package com.hachan.assignment.ecception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundEcception extends RuntimeException{
private static final long serialVersionUID = 1L;
	public UserNotFoundEcception(String message) {
		super(message);
	}
}
