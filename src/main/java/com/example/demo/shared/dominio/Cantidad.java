package com.example.demo.shared.dominio;

import com.example.demo.exceptions.CantidadException;

public class Cantidad {
	
	private final Integer cantidad;

	public Cantidad(Integer cantidad) {
		
		try {
			this.cantidad = cantidad;
			if (cantidad <= 0 || cantidad > 1001) {
				throw new CantidadException();
			}
		} catch (NullPointerException e) {
			throw new CantidadException();
		}
	}

	public Integer getCantidad() {
		return cantidad;
	}
}
