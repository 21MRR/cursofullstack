package com.educandoweb.cursofullstack.services.exception;

public class DataIntregryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntregryException(String msg) {
		super(msg);

	}

	public DataIntregryException(String msg, Throwable cause) {
		super(msg, cause);

	}

}
