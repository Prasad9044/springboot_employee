package com.qsp.springbootemployee.exception;

public class IdNotFound extends RuntimeException {
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFound(String message) {
		super();
		this.message = message;
	}

}
