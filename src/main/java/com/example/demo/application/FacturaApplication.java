package com.example.demo.application;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dominio.services.FacturaService;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infrastructure.RestDto.FacturaRest;
import com.example.demo.infrastructure.RestDto.ItemRest;
import com.example.demo.infrastructure.RestDto.ProductoRest;
import com.example.demo.infrastructure.mapper.FacturaMapper;
import com.example.demo.infrastructure.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;

public class FacturaApplication {
	
	private FacturaService facturaService;
	private ProductoService productoService;
	private FacturaMapper facturaMapper;
	private ProductoMapper productoMapper;
	
	public FacturaApplication(FacturaService facturaService, ProductoService productoService,
			FacturaMapper facturaMapper, ProductoMapper productoMapper) {
		this.facturaService = facturaService;
		this.productoService = productoService;
		this.facturaMapper = facturaMapper;
		this.productoMapper = productoMapper;
	}

	public Double calcularValorTotal (List<ItemRest> items) {
		Double valor_total = 0.0;
		for (ItemRest item : items) {
			item.setId(1L);
			item.setValor_total(item.getCantidad() * item.getProducto().getValor());
			valor_total += item.getValor_total();
		}
		return valor_total;
	}
	
	public List<Codigo> obtenerCodigos (List<ItemRest> items) {
		return items.stream().map(item -> new Codigo(item.getProducto().getCodigo())).collect(Collectors.toList());
	}
	
	public void cargarProductos (List<ItemRest> items) {
		List<ProductoRest> productos = productoMapper.DomToRest(productoService.buscarPorIds(obtenerCodigos(items)));
		for (ItemRest item : items) {
			item.setProducto(productos.stream().filter(producto -> producto.getCodigo().equals(item.getProducto().getCodigo())).findAny().orElseThrow(() -> new RegistroNoEncontradoException()));
		}
	}
	
	public FacturaRest crear (FacturaRest factura, Long numero) {
		numero = numero == null ? 1L : numero;
		factura.setNumero(numero);
		cargarProductos(factura.getItems());
		factura.setValor_total(calcularValorTotal(factura.getItems()));
		FacturaRest obtenida = facturaMapper.DomToRest(facturaService.guardar(facturaMapper.RestToDom(factura)));
		System.out.println("Factura -> "+obtenida);
		return obtenida;
	}
	
	public List<FacturaRest>  mostrarTodos () {
		List<FacturaRest> facturas = facturaMapper.DomToRest(facturaService.buscarTodos());
		System.out.println("Facturas -> "+facturas);
		return facturas;
	}
	
	public FacturaRest mostrarUno (Long numero) {
		FacturaRest factura = facturaMapper.DomToRest(facturaService.buscarPorId(new Id(numero)));
		System.out.println("Factura -> "+factura);
		return factura;
	}
	
	public FacturaRest actualizar(FacturaRest factura, Long numero) {
		mostrarUno(numero);
		System.out.println("Actualizado -> ");
		crear(factura, numero);
		return factura;
	}
	
	public void eliminar (Long numero) {
		FacturaRest factura = facturaMapper.DomToRest(facturaService.eliminarPorId(new Id(numero)));
		System.out.println("Eliminado -> "+factura);
	}
}
