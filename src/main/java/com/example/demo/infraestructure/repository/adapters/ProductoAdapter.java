package com.example.demo.infraestructure.repository.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infraestructure.repository.database.ProductoRepository;
import com.example.demo.infraestruture.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

@Service
public class ProductoAdapter implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.DomToDto(producto));
	}

	@Override
	public List<Producto> buscarTodos() {
		return productoMapper.DtoToDom(productoRepository.findAll());
	}
	
	@Override
	public Producto buscarPorId(Codigo codigo) {
		return productoMapper.DtoToDom(productoRepository.findById(codigo.getCodigo()).orElseThrow(() -> new RegistroNoEncontradoException()));
	}
	
	@Override
	public List<Producto> buscarPorIds(List<Codigo> codigos) {
		return productoMapper.DtoToDom(productoRepository.findAllById(codigos.stream().map(codigo -> codigo.getCodigo()).collect(Collectors.toList())));
	}
	
	@Override
	public Producto actualizarPorId(Producto producto, Codigo codigo) {
		Producto encontrado = buscarPorId(codigo);
		guardar(producto);
		return encontrado;
	}
	
	@Override
	public Producto eliminarPorId(Codigo codigo) {
		Producto producto = buscarPorId(codigo);
		productoRepository.deleteById(codigo.getCodigo());
		return producto;
	}
}
