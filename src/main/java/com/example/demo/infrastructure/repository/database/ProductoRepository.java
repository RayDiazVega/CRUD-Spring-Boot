package com.example.demo.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.infrastructure.Dto.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String>{
	
}
