package com.example.demo.shared.dominio;

import com.example.demo.exceptions.CodigoException;

public class Codigo {
	
	private final String codigo;
	
	public Codigo(String codigo) {
		
		try {
			this.codigo = codigo;
			if (codigo.length() > 8) {
				throw new CodigoException();
			}
		} catch (NullPointerException e) {
			throw new CodigoException();
		}
		
	}

	public String getCodigo() {
		return codigo;
	}
	
}
