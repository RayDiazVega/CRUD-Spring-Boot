package com.example.demo.application;

import java.util.List;

import com.example.demo.dominio.services.ProductoService;
import com.example.demo.infrastructure.RestDto.ProductoRest;
import com.example.demo.infrastructure.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

public class ProductoApplication {
	
	private ProductoService productoService;
	private ProductoMapper productoMapper;
	
	public ProductoApplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public ProductoRest crear (ProductoRest producto) {
		productoService.guardar(productoMapper.RestToDom(producto));
		System.out.println("Creado -> "+producto);
		return producto;
	}
	
	public List<ProductoRest> mostrarTodos () {
		List<ProductoRest> productos = productoMapper.DomToRest(productoService.buscarTodos());
		System.out.println("Elementos -> "+productos);
		return productos;
	}
	
	public ProductoRest mostrarUno (String codigo) {
		ProductoRest producto = productoMapper.DomToRest(productoService.buscarPorId(new Codigo(codigo)));
		System.out.println("Elemento -> "+producto);
		return producto;
	}
	
	public ProductoRest actualizar (ProductoRest producto, String codigo) {
		ProductoRest encontrado = productoMapper.DomToRest(productoService.actualizarPorId(productoMapper.RestToDom(producto), new Codigo(codigo)));
		System.out.println("Producto -> "+encontrado+" Actualizado -> "+producto);
		return producto;
	}
	
	public void eliminar (String codigo) {
		ProductoRest producto = productoMapper.DomToRest(productoService.eliminarPorId(new Codigo(codigo)));
		System.out.println("Eliminado -> "+producto);
	}
}
