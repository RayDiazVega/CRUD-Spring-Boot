package com.example.demo.infrastructure.repository.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infrastructure.Dto.ProductoDto;
import com.example.demo.infrastructure.mapper.ProductoMapper;
import com.example.demo.infrastructure.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

	@Override
	public String generateReport () throws FileNotFoundException, JRException{
		String path = "C:\\Users\\ACER1\\Documents\\Report";
		List<ProductoDto> productos = productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
		File file = ResourceUtils.getFile("classpath:productos.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Aztrarok");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Productos.pdf");
		return "report generated in path : " + path;
	}
}
