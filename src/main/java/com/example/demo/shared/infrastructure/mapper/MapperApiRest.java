package com.example.demo.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest <I, O> {
	
	public O DomToRest(I i);//Dominio a ApiRest
	
	public I RestToDom(O o);//ApiRest a Dominio
	
	public default List<O> DomToRest(List<I> instancias){//Lista de dominio a lista de ApiRest
		return instancias.stream().map(this::DomToRest).collect(Collectors.toList());
	}
	
	public default List<I> RestToDom(List<O> instancias){//Lista de ApiRest a lista de Dominio
		return instancias.stream().map(this::RestToDom).collect(Collectors.toList());
	}

}
