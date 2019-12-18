package com.example.demo.exceptions;

public class ValorException extends RuntimeException {
	
	public ValorException() {
		super("El valor debe ser mayor o igual a 1");
	}
}
