package com.example.demo.infraestruture.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructure.RestDto.ProductoRest;
import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infraestructure.mapper.MapperApiRest;
import com.example.demo.shared.infraestructure.mapper.MapperRepository;

@Component
public class ProductoMapper implements MapperApiRest<Producto, ProductoRest>, MapperRepository<Producto, ProductoDto>{

	@Override
	public Producto RestToDom(ProductoRest o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoRest DomToRest(Producto i) {
		return new ProductoRest(i.getCodigo().getCodigo(), i.getNombre().getNombre(), i.getValor().getValor());
	}

	@Override
	public Producto DtoToDom(ProductoDto o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoDto DomToDto(Producto i) {
		return new ProductoDto(i.getCodigo().getCodigo(), i.getNombre().getNombre(), i.getValor().getValor());
	}
}
