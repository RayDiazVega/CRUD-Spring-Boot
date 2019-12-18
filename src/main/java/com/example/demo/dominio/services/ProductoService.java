package com.example.demo.dominio.services;

import java.util.List;

import com.example.demo.dominio.model.Producto;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.exceptions.RegistroNoEncontradoException;


public interface ProductoService {
	
	public void guardar (Producto producto);
	
	public List<Producto> buscarTodos();
	
	/**
	 * Retrieves an entity by its codigo.
	 *
	 * @param codigo must not be {@literal null}.
	 * @return the entity with the given codigo or {@literal Optional#empty()} if none found.
	 * @throws RegistroNoEncontradoException if {@literal codigo} is {@literal null}.
	 */
	public Producto buscarPorId (Codigo codigo);
	
	public List<Producto> buscarPorIds (List<Codigo> codigos);

	public Producto actualizarPorId(Producto producto, Codigo codigo);
	
	public Producto eliminarPorId (Codigo codigo);
}
