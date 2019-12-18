package com.example.demo.shared.dominio;

import java.util.regex.Pattern;

import com.example.demo.exceptions.NombreException;

public class Nombre {
	
	private final  String nombre;
	
	public Nombre(String nombre) {
		
		try {
			this.nombre = nombre;
			if (!Pattern.matches("[A-Z\\s]+", nombre)) {
				throw new NombreException();
			}
		} catch (NullPointerException e) {
			throw new NombreException();
		}
		
	}

	public String getNombre() {
		return nombre;
	}
	
}
