package com.erdal.exeptions;

public class CategoryBadRequestExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	public CategoryBadRequestExeption(String message) {
		super(message);
	}

	public CategoryBadRequestExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}
