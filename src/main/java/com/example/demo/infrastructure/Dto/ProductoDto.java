package com.example.demo.infrastructure.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class ProductoDto extends BaseEntity{

	@Id
	private String codigo;
	private String nombre;
	private Double valor;
	
	protected ProductoDto() {}
	
	public ProductoDto(String codigo, String nombre, Double valor) {
		super();
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
}
