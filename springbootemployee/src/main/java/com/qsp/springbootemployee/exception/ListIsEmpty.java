package com.qsp.springbootemployee.exception;

public class ListIsEmpty extends RuntimeException {
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public ListIsEmpty(String message) {
		super();
		this.message = message;
	}

}
