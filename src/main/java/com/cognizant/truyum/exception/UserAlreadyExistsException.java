package com.cognizant.truyum.exception;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 3L;

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
