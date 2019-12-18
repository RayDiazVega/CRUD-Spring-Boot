package com.example.demo.exceptions;

public class CodigoException extends RuntimeException {
	
	public CodigoException() {
		super("El codigo debe tener menos de 8 caracteres");
	}
}
