package com.example.demo.exceptions;

public class RegistroNoEncontradoException extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RegistroNoEncontradoException() {
		super("Elemento no encontrado");
	}
	
}

