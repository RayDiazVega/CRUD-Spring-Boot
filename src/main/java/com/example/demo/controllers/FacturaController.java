package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.FacturaApplication;
import com.example.demo.dominio.services.FacturaService;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.infraestructure.RestDto.FacturaRest;
import com.example.demo.infraestruture.mapper.FacturaMapper;
import com.example.demo.infraestruture.mapper.ProductoMapper;


@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	private FacturaApplication facturaApplication;
	
	public FacturaController(@Autowired FacturaService facturaService, @Autowired ProductoService productoService,
							@Autowired FacturaMapper facturaMapper, @Autowired ProductoMapper productoMapper) {
		this.facturaApplication = new FacturaApplication(facturaService, productoService, facturaMapper, productoMapper);
	}
	
	@PostMapping
	public FacturaRest crear (@RequestBody FacturaRest factura) {
		return facturaApplication.crear(factura, null);
	}
	
	@GetMapping
	public List<FacturaRest>  mostrarTodos () {
		return facturaApplication.mostrarTodos();
	}
	
	@GetMapping("/{numero}")
	public FacturaRest mostrarUno (@PathVariable Long numero) {
		return facturaApplication.mostrarUno(numero);
	}
	
	@PutMapping("/{numero}")
	public FacturaRest actualizar (@RequestBody FacturaRest factura, @PathVariable Long numero) {
		return facturaApplication.actualizar(factura, numero);
	}
	
	@DeleteMapping("/{numero}")
	public void eliminar (@PathVariable Long numero) {
		facturaApplication.eliminar(numero);
	}
}
