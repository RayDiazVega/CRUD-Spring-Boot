package com.example.demo.infrastructure.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class FacturaDto extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numero;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDto> items;
	private Double valor_total;
	
	public FacturaDto() {}

	public FacturaDto(Long numero, String nombre, List<ItemDto> items, Double valor_total) {
		super();
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

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
}
