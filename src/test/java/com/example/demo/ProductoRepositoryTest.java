package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.infrastructure.Dto.ProductoDto;
import com.example.demo.infrastructure.repository.database.ProductoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductoRepositoryTest {
    
	@Autowired
	private  ProductoRepository productoRepository;

	@Test
	public void whenFindById_thenReturnProductoDto() throws Exception {

		ProductoDto productoDto = new ProductoDto("009", "SILLA", 89.5);
        productoRepository.save(productoDto);
		ProductoDto foundDto = productoRepository.findById("009").get();
		assertEquals(productoDto.getNombre(), foundDto.getNombre());
	}
}