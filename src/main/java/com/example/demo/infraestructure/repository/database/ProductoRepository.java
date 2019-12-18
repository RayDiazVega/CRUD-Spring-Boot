package com.example.demo.infraestructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructure.dto.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String>{
	
}
