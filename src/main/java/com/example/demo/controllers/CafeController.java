package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CafeController {

	@GetMapping("/hola")
	public String hola() {
		return "Hola";
	}
}
