package com.example.demo.dominio.model;

import java.util.List;

import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;

public class Factura {
	
	private final Id numero;
	private final Nombre nombre;
	private final List<Item> items;
	private final Valor valor_total;
	
	private Factura(Id numero, Nombre nombre, List<Item> items, Valor valor_total) {
		this.numero = numero;
		this.nombre = nombre;
		this.items = items;
		this.valor_total = valor_total;
	}

	public Id getNumero() {
		return numero;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public List<Item> getItems() {
		return items;
	}

	public Valor getValor_total() {
		return valor_total;
	}
	
	public static Factura of(Id numero, Nombre nombre, List<Item> items, Valor valor_total) {
		return new Factura(numero, nombre, items, valor_total);
	}
}
