package com.example.demo.infrastructure.RestDto;

public class ItemRest {
	
	private Long id;
	private Integer cantidad;
	private ProductoRest producto;
	private Double valor_total;
	
	public ItemRest() {}

	public ItemRest(Long id, Integer cantidad, ProductoRest producto, Double valor_total) {
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor_total = valor_total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoRest getProducto() {
		return producto;
	}

	public void setProducto(ProductoRest producto) {
		this.producto = producto;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	
	@Override
	public String toString() {
		return "\n\t\t\t{ id: "+id+", cantidad: "+cantidad+", producto: "+producto.toString()+", valor total: "+valor_total+" }";
	}
	
}
