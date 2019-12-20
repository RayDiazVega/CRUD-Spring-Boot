package com.example.demo.infrastructure.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.model.Factura;
import com.example.demo.dominio.services.FacturaService;
import com.example.demo.exceptions.RegistroNoEncontradoException;
import com.example.demo.infrastructure.repository.database.FacturaRepository;
import com.example.demo.infrastructure.mapper.FacturaMapper;
import com.example.demo.shared.dominio.Id;

@Service
public class FacturaAdapter implements FacturaService {
	
	@Autowired
	public FacturaRepository facturaRepository;
	
	@Autowired
	public FacturaMapper facturaMapper;
	
	@Override
	public Factura guardar(Factura factura) {
		return facturaMapper.DtoToDom(facturaRepository.save(facturaMapper.DomToDto(factura)));
	}

	@Override
	public List<Factura> buscarTodos() {
		return facturaMapper.DtoToDom(facturaRepository.findAll());
	}

	@Override
	public Factura buscarPorId(Id numero) {
		return facturaMapper.DtoToDom(facturaRepository.findById(numero.getId()).orElseThrow(() -> new RegistroNoEncontradoException()));
	}
	
	@Override
	public Factura actualizarPorId(Factura factura, Id numero) {
		Factura encontrado = buscarPorId(numero);
		guardar(factura);
		return encontrado;
	}

	@Override
	public Factura eliminarPorId(Id numero) {
		Factura factura = buscarPorId(numero);
		facturaRepository.deleteById(numero.getId());
		return factura;
	}
	
}
