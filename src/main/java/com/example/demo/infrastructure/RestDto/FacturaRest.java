package com.example.demo.infrastructure.RestDto;

import java.util.List;

public class FacturaRest {
	
	private Long numero;
	private String nombre;
	private List<ItemRest> items;
	private Double valor_total;
	
	public FacturaRest() {}

	public FacturaRest(Long numero, String nombre, List<ItemRest> items, Double valor_total) {
		this.numero = numero;
		this.nombre = nombre;
		this.items = items;
		this.valor_total = valor_total;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ItemRest> getItems() {
		return items;
	}

	public void setItems(List<ItemRest> items) {
		this.items = items;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	@Override
	public String toString() {
		return "{ \tnumero:"+numero+", \n\t\tnombre: "+nombre+", \n\t\titems: "+items.toString()+", \n\t\tvalor_total: "+valor_total+"\n}";
	}
}
