package com.example.demo.controllers;


import java.util.List;
import java.util.Map;

import com.example.demo.application.CafeApplication;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class CafeController {

	private CafeApplication cafeApplication = new CafeApplication();

	@GetMapping("/hola")
	public String hola() {
		return "Hola";
	}

	@PostMapping("/excel")
	public Map<String, List<Map<Object, Object>>> upload(@RequestParam("file") MultipartFile file) throws Exception {
		return cafeApplication.upload(file);
	}
}
