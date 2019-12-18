package com.example.demo.dominio.model;

import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Valor;

public class Item {
	
	private final Id id;
	private final Cantidad cantidad;
	private final Producto producto;
	private final Valor valor_total;
	
	private Item(Id id, Cantidad cantidad, Producto producto, Valor valor_total) {
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor_total = valor_total;
	}

	public Id getId() {
		return id;
	}

	public Cantidad getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public Valor getValor_total() {
		return valor_total;
	}
	
	public static Item of(Id id, Cantidad cantidad, Producto producto, Valor valor_total) {
		return new Item(id, cantidad, producto, valor_total);
	}
}
