package com.example.demo.exceptions;

public class ValorException extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ValorException() {
		super("El valor debe ser mayor o igual a 1");
	}
	
}
