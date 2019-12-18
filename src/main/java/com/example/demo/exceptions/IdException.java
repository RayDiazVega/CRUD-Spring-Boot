package com.example.demo.exceptions;

public class IdException extends RuntimeException {
	
	public IdException() {
		super("El id dete ser mayor a 0");
	}
}
