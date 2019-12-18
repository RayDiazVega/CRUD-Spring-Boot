package com.example.demo.shared.dominio;

import com.example.demo.exceptions.ValorException;

public class Valor {
	
	private final Double valor;
	
	public Valor(Double valor) {
		
		try {
			this.valor = valor;
			if (valor <= 0 || valor > 999999) {
				throw new ValorException();
			}
		} catch (NullPointerException e) {
			throw new ValorException();
		}
		
	}

	public Double getValor() {
		return valor;
	}
	
}
