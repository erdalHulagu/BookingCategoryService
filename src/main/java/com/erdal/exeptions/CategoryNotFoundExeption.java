package com.erdal.exeptions;

public class CategoryNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long id;

	public CategoryNotFoundExeption(String message) {
		super(message);
	}

	public CategoryNotFoundExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}