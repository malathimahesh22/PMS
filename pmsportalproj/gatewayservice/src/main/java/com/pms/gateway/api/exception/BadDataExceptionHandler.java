package com.pms.gateway.api.exception;

public class BadDataExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1795793256923097719L;

	public BadDataExceptionHandler(String message) {
		super(message);
	}

}
