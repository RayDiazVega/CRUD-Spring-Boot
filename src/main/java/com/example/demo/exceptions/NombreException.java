package com.example.demo.exceptions;


public class NombreException extends RuntimeException{
	
	public NombreException() {
		super("El nombre solo debe contener mayusculas y espacios");
	}
}
