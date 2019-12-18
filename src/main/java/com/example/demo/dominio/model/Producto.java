package com.example.demo.dominio.model;

import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;

public class Producto {
	
	private final Codigo codigo;
	private final Nombre nombre;
	private final Valor valor;
	
	private Producto(Codigo codigo, Nombre nombre, Valor valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public Codigo getCodigo() {
		return codigo;
	}
	
	public Nombre getNombre() {
		return nombre;
	}
	
	public  Valor getValor() {
		return valor;
	}
	
	public static Producto of(Codigo codigo, Nombre nombre, Valor valor) {
		return new Producto(codigo, nombre, valor);
	}
}
