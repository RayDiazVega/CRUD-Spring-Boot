package com.example.demo.shared.dominio;

import com.example.demo.exceptions.IdException;

public class Id {

	private final Long id;

	public Id(Long id) {
			
		try {
			this.id = id;
			if (id <= 0) {
				throw new IdException();
			}
		} catch (NullPointerException e) {
			throw new IdException();
		}
		
	}

	public Long getId() {
		return id;
	}
}
