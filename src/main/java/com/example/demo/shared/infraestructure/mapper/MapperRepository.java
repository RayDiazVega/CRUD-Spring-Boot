package com.example.demo.shared.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRepository <I, O>{
	
	public O DomToDto(I i);//Dominio a Dto
	
	public I DtoToDom(O o);
	
	public default List<O> DomToDto(List<I> instancias){
		return instancias.stream().map(this::DomToDto).collect(Collectors.toList());
	}
	
	public default List<I> DtoToDom(List<O> instancias){
		return instancias.stream().map(this::DtoToDom).collect(Collectors.toList());
	}
	

}
