package com.example.demo.exceptions;

public class CantidadException extends RuntimeException {
	
	public CantidadException() {
		super("La cantidad debe ser mayor a 0 y menor o igual a 1000");
	}
}
