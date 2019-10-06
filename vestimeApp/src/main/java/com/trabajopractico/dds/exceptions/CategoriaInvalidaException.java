package com.trabajopractico.dds.exceptions;

public class CategoriaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CategoriaInvalidaException(String mensaje) {
		super(mensaje);
	}
}
