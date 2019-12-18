package com.example.demo.infraestruture.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Factura;
import com.example.demo.infraestructure.RestDto.FacturaRest;
import com.example.demo.infraestructure.dto.FacturaDto;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infraestructure.mapper.MapperApiRest;
import com.example.demo.shared.infraestructure.mapper.MapperRepository;

@Component
public class FacturaMapper implements MapperApiRest<Factura, FacturaRest>, MapperRepository<Factura, FacturaDto>{
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public Factura RestToDom(FacturaRest o) {
		return Factura.of(new Id(o.getNumero()), new Nombre(o.getNombre()), itemMapper.RestToDom(o.getItems()), new Valor(o.getValor_total()));
	}
	
	@Override
	public FacturaRest DomToRest(Factura i) {
		return new FacturaRest(i.getNumero().getId(), i.getNombre().getNombre(), itemMapper.DomToRest(i.getItems()), i.getValor_total().getValor());
	}

	@Override
	public Factura DtoToDom(FacturaDto o) {
		return Factura.of(new Id(o.getNumero()), new Nombre(o.getNombre()), itemMapper.DtoToDom(o.getItems()), new Valor(o.getValor_total()));
	}
	
	@Override
	public FacturaDto DomToDto(Factura i) {
		return new FacturaDto(i.getNumero().getId(), i.getNombre().getNombre(), itemMapper.DomToDto(i.getItems()), i.getValor_total().getValor());

	}


	
	
}
