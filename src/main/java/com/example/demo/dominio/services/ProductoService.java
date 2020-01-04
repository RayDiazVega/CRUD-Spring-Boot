package com.example.demo.dominio.services;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.demo.dominio.model.Producto;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;


public interface ProductoService {
	
	/**
	 * Saves a given {@literal Producto}.
	 *
	 * @param Producto must not be {@literal null}.
	 */
	public void guardar (Producto producto);
	
	/**
	 * Returns all instances of Producto.
	 *
	 * @return all Productos.
	 */
	public List<Producto> buscarTodos();
	
	/**
	 * Retrieves an entity by its codigo.
	 *
	 * @param codigo must not be {@literal null}.
	 * @return the entity with the given codigo
	 * @throws RegistroNoEncontradoException if {@literal codigo} not found.
	 */
	public Producto buscarPorId (Codigo codigo);
	
	/**
	 * Returns all instances of {@literal Producto} with the given {@literal codigos}.
	 * <p>
	 * If some or all codigos are not found, throws RegistroNoEncontradoException.
	 * <p>
	 * Note that the order of elements in the result is not guaranteed.
	 *
	 * @param codigos must not be {@literal null} nor contain any {@literal null} values.
	 * @return guaranteed to be not {@literal null}. The size can be equal or less than the number of given
	 *         {@literal codigos}.
	 */
	public List<Producto> buscarPorIds (List<Codigo> codigos);
	
	/**
	 * Update the Producto with the given codigo.
	 *
	 * @param codigo must not be {@literal null}.
	 * @param producto must not be {@literal null}.
	 * @return the entity updated.
	 * @throws RegistroNoEncontradoException if {@literal codigo} not found.
	 */
	public Producto actualizarPorId(Producto producto, Codigo codigo);
	
	/**
	 * Deletes the Producto with the given codigo.
	 *
	 * @param codigo must not be {@literal null}.
	 * @return the entity deleted.
	 * @throws RegistroNoEncontradoException if {@literal codigo} not found.
	 */
	public Producto eliminarPorId (Codigo codigo);

	/**
	 * Generate report for the producto entity
	 * 
	 * @param none
	 * @return String "report generated in path..."
	 * @throws FileNotFoundException if file not found.
	 * @throws JRException failed to get sources.
	 */
	public String generateReport () throws FileNotFoundException, JRException;
	
}
