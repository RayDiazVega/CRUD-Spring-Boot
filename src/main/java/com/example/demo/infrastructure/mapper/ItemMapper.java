package com.example.demo.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Item;
import com.example.demo.infrastructure.RestDto.ItemRest;
import com.example.demo.infrastructure.Dto.ItemDto;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infrastructure.mapper.MapperApiRest;
import com.example.demo.shared.infrastructure.mapper.MapperRepository;

@Component
public class ItemMapper implements MapperApiRest<Item, ItemRest>, MapperRepository<Item, ItemDto>{

	@Autowired
	private ProductoMapper productoMapper;
	
	@Override
	public Item RestToDom(ItemRest o) {
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()), productoMapper.RestToDom(o.getProducto()), new Valor(o.getValor_total()));
	}

	@Override
	public ItemRest DomToRest(Item i) {
		return new ItemRest(i.getId().getId(), i.getCantidad().getCantidad(), productoMapper.DomToRest(i.getProducto()), i.getValor_total().getValor());
	}

	@Override
	public Item DtoToDom(ItemDto o) {
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()), productoMapper.DtoToDom(o.getProducto()), new Valor(o.getValor_total()));
	}

	@Override
	public ItemDto DomToDto(Item i) {
		return new ItemDto(i.getId().getId(), i.getCantidad().getCantidad(), productoMapper.DomToDto(i.getProducto()), i.getValor_total().getValor());
	}
}
