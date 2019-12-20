package com.example.demo.infrastructure.RestDto;

public class ProductoRest {
	
	private String codigo;
	private String nombre;
	private Double valor;
	
	protected ProductoRest() {}
	
	public ProductoRest(String codigo, String nombre, Double valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "{codigo: "+codigo+", nombre: "+nombre+", valor: "+valor+"}";
	}
}
